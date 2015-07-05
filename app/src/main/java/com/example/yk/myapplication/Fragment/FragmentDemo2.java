package com.example.yk.myapplication.Fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yk.myapplication.R;

public class FragmentDemo2 extends Activity implements View.OnClickListener {


    private MessageFragment messageFragment;
    private ContactFragment contactFragment;
    private NewsFragment newsFragment;
    private SettingFragment settingFragment;

    private View messageLayout;
    private View contactsLayout;
    private View newsLayout;
    private View settingLayout;

    /**
     * 在Tab布局上显示图标的控件
     */
    private ImageView messageImage;
    private ImageView contactsImage;
    private ImageView newsImage;
    private ImageView settingImage;

    /**
     * 在Tab布局上显示图标的控件
     */
    private TextView messageText;
    private TextView contactText;
    private TextView newsText;
    private TextView settingText;

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo2);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    /**
     * 初始化各种控件和view
     */
    private void initViews() {
        messageLayout = findViewById(R.id.message_layout);
        messageImage = (ImageView) findViewById(R.id.message_img);
        messageText = (TextView) findViewById(R.id.message_text);
        messageLayout.setOnClickListener(this);

        contactsLayout = findViewById(R.id.contacts_layout);
        contactsImage = (ImageView) findViewById(R.id.contacts_img);
        contactText = (TextView) findViewById(R.id.contacts_text);
        contactsLayout.setOnClickListener(this);

        newsLayout = findViewById(R.id.news_layout);
        newsImage = (ImageView) findViewById(R.id.news_img);
        newsText = (TextView) findViewById(R.id.news_text);
        newsLayout.setOnClickListener(this);

        settingLayout = findViewById(R.id.setting_layout);
        settingImage = (ImageView) findViewById(R.id.setting_img);
        settingText = (TextView) findViewById(R.id.setting_text);
        settingLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    public void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                messageImage.setImageResource(R.drawable.message_selected);
                messageText.setTextColor(Color.WHITE);
                if (messageFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    messageFragment = new MessageFragment();
                  //  transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                  //  transaction.show(messageFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactText.setTextColor(Color.WHITE);
                if (contactFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    contactFragment = new ContactFragment();
                  //  transaction.add(R.id.content, contactFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                 //   transaction.show(contactFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (newsFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    newsFragment = new NewsFragment();
                   // transaction.add(R.id.content, newsFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                  //  transaction.show(newsFragment);
                }
                break;
            case 3:
            default:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                settingImage.setImageResource(R.drawable.setting_selected);
                settingText.setTextColor(Color.WHITE);
                if (settingFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    settingFragment = new SettingFragment();
                   // transaction.add(R.id.content, settingFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                  //  transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }




    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }


    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (messageFragment != null) {
           // transaction.hide(messageFragment);
        }
        if (contactFragment != null) {
           // transaction.hide(contactFragment);
        }
        if (newsFragment != null) {
          //  transaction.hide(newsFragment);
        }
        if (settingFragment != null) {
          //  transaction.hide(settingFragment);
        }

    }
}
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_fragment_demo2, menu);
//        return true;
//    }

 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

