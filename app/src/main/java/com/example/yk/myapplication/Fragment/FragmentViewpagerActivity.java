package com.example.yk.myapplication.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/6/30.
 */
public class FragmentViewpagerActivity extends FragmentActivity implements View.OnClickListener{

    FragmentPagerAdapter adapterViewPager;

    private static View messageLayout;
    private static View contactsLayout;
    private static View newsLayout;
    private static View settingLayout;


    ViewPager viewPager;
    /**
     * 在Tab布局上显示图标的控件
     */
    private static ImageView messageImage;
    private static ImageView contactsImage;
    private static ImageView newsImage;
    private static ImageView settingImage;

    /**
     * 在Tab布局上显示图标的控件
     */
    private static TextView messageText;
    private static TextView contactText;
    private static TextView newsText;
    private static TextView settingText;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_viewpager);

        initViews();
      //  setTabSelection(0);

        adapterViewPager = new MyAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapterViewPager);

       viewPager.setCurrentItem(0);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(FragmentViewpagerActivity.this,
                        "Selected page position: " + position, Toast.LENGTH_SHORT).show();
                clearSelection();
                switch (position) {
                    case 0:
                        messageImage.setImageResource(R.drawable.message_selected);
                        messageText.setTextColor(Color.WHITE);
                        break;
                    case 1:
                        contactsImage.setImageResource(R.drawable.contacts_selected);
                        contactText.setTextColor(Color.WHITE);
                        break;
                    case 2:
                        newsImage.setImageResource(R.drawable.news_selected);
                        newsText.setTextColor(Color.WHITE);
                        break;
                    case 3:
                        settingImage.setImageResource(R.drawable.setting_selected);
                        settingText.setTextColor(Color.WHITE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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

        viewPager = (ViewPager) findViewById(R.id.content1);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                viewPager.setCurrentItem(0);
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                viewPager.setCurrentItem(1);
                break;
            case R.id.news_layout:
                // 当点击了动态tab时，选中第3个tab
                viewPager.setCurrentItem(2);
                break;
            case R.id.setting_layout:
                // 当点击了设置tab时，选中第4个tab
                viewPager.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

  /*  public void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
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
                    transaction.add(R.id.content, messageFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                      transaction.show(messageFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                contactsImage.setImageResource(R.drawable.contacts_selected);
                contactText.setTextColor(Color.WHITE);
                if (contactFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    contactFragment = new ContactFragment();
                      transaction.add(R.id.content, contactFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                       transaction.show(contactFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                newsImage.setImageResource(R.drawable.news_selected);
                newsText.setTextColor(Color.WHITE);
                if (newsFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.content, newsFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                      transaction.show(newsFragment);
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
                    transaction.add(R.id.content, settingFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                      transaction.show(settingFragment);
                }
                break;
        }
        transaction.commit();
    }*/


    /**
     * 清除掉所有的选中状态。
     */
    private static void clearSelection() {
        messageImage.setImageResource(R.drawable.message_unselected);
        messageText.setTextColor(Color.parseColor("#82858b"));
        contactsImage.setImageResource(R.drawable.contacts_unselected);
        contactText.setTextColor(Color.parseColor("#82858b"));
        newsImage.setImageResource(R.drawable.news_unselected);
        newsText.setTextColor(Color.parseColor("#82858b"));
        settingImage.setImageResource(R.drawable.setting_unselected);
        settingText.setTextColor(Color.parseColor("#82858b"));
    }



    public static class MyAdapter extends FragmentPagerAdapter{
        private static int NUM_ITEMS = 4;

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            content.setVisibility(View.INVISIBLE);
            switch (position) {
                case 0:
                    messageImage.setImageResource(R.drawable.message_selected);
                    messageText.setTextColor(Color.WHITE);
                    return new MessageFragment();
                case 1:
                    return new ContactFragment();
                case 2:
                    return new NewsFragment();
                case 3:
                    return new SettingFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}
