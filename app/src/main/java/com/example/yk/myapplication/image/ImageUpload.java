package com.example.yk.myapplication.image;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.yk.myapplication.MainActivity;
import com.example.yk.myapplication.R;
import com.example.yk.myapplication.util.Base64Coder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ImageUpload extends Activity implements View.OnClickListener {

    private static final String TAG = "uploadImage";
    private static String requestURL = "http://10.10.10.106:8080/viewSpot/test1";
    private Button selectImage, uploadImage;
    private ImageView imageView;
    private String picPath = null;

    Bitmap bitmap;

    private Handler myHandler;
    private ProgressDialog myDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);
        selectImage = (Button) this.findViewById(R.id.selectImage);
        uploadImage = (Button) this.findViewById(R.id.uploadImage);
        selectImage.setOnClickListener(this);
        uploadImage.setOnClickListener(this);

        imageView = (ImageView) this.findViewById(R.id.imageView);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selectImage:
                /***
                 * 这个是调用android内置的intent，来过滤图片文件   ，同时也可以过滤其他的
                 */
                Intent intent = new Intent(Intent.ACTION_PICK, null);
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 1);
                break;
            case R.id.uploadImage:


//
//                String mimeType = "multipart/form-data";
//                TypedFile file = new TypedFile(mimeType,new File(picPath));
//                TypedString string = new TypedString("1111");
//                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(requestURL).build();
//                Upload service = restAdapter.create(Upload.class);
//                String reponseString = service.upload(file,string,new Callback() {
//
//
//                });

//                File file = new File(picPath);
//                if (file != null) {
//                    String request = UploadFile.uploadFile(file, requestURL);
//                    uploadImage.setText(request);
//                }
                myDialog = ProgressDialog.show(this, "Loading...", "Please wait...", true, false);
                new Thread(new Runnable() {
                    public void run() {
                        upload();
//                        myHandler.sendMessage(new Message());
                    }
                }).start();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            /**
             * 当选择的图片不为空的话，在获取到图片的途径
             */
            Uri uri = data.getData();
            Log.e(TAG, "uri = " + uri);
            try {
                String[] pojo = {MediaStore.Images.Media.DATA};
//                StringBuffer buffer = new StringBuffer();
//                buffer.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=").append("'" + Uri.decode(uri.getEncodedPath()) + "'").append(")");
//                Cursor cursor = this.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                        new String[]{MediaStore.Images.ImageColumns._ID}, buffer.toString(), null, null);
                @SuppressWarnings("deprecation")
                Cursor cursor = managedQuery(uri, pojo, null, null, null);
                if (cursor != null) {
                    ContentResolver cr = this.getContentResolver();
                    int colunm_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                    cursor.moveToFirst();
                    String path = cursor.getString(colunm_index);
                    /***
                     * 这里加这样一个判断主要是为了第三方的软件选择，比如：使用第三方的文件管理器的话，你选择的文件就不一定是图片了，这样的话，我们判断文件的后缀名
                     * 如果是图片格式的话，那么才可以
                     */
                    if (path.endsWith("jpg") || path.endsWith("png")) {
                        picPath = path;
                        bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                        imageView.setImageBitmap(bitmap);
                    } else {
                        alert();
                    }
//                    picPath = path;
//                    Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
//                    imageView.setImageBitmap(bitmap);
                } else {
                    alert();
                }
                cursor.close();
            } catch (Exception e) {
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void alert() {
        Dialog dialog = new AlertDialog.Builder(this)
                .setTitle("提示")
                .setMessage("您选择的不是有效的图片")
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                picPath = null;
                            }
                        })
                .create();
        dialog.show();
    }


    // 上传
    public void upload() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream);
        byte[] b = stream.toByteArray();
        // 将图片流以字符串形式存储下来
        String file = new String(Base64Coder.encodeLines(b));
        HttpClient client = new DefaultHttpClient();
        // 设置上传参数
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        formparams.add(new BasicNameValuePair("file", file));
        HttpPost post = new HttpPost(requestURL);
        UrlEncodedFormEntity entity;
        try {
            entity = new UrlEncodedFormEntity(formparams, "UTF-8");
            post.addHeader("Accept",
                    "text/javascript, text/html, application/xml, text/xml");
            post.addHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
            post.addHeader("Accept-Encoding", "gzip,deflate,sdch");
            post.addHeader("Connection", "Keep-Alive");
            post.addHeader("Cache-Control", "no-cache");
            post.addHeader("Content-Type", "application/x-www-form-urlencoded");
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine().getStatusCode());
            HttpEntity e = response.getEntity();
            System.out.println(EntityUtils.toString(e));
            if (200 == response.getStatusLine().getStatusCode()) {
                System.out.println("上传完成");
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            } else {
                System.out.println("上传失败");
            }
            client.getConnectionManager().shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            myDialog.dismiss();
        }
    }
}