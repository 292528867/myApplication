package com.example.yk.myapplication.slidingPanelLayout;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/8/10.
 */
public class SlidingPanelLayoutActivity  extends Activity implements BookMarkerFragement.BookmarkListener {

    Fragment bookmarkerFragment;
    Fragment showFragment;
    SlidingPaneLayout spl = null;
    ActionBar actionBar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_panel_layout);
        actionBar = this.getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        spl = (SlidingPaneLayout) this.findViewById(R.id.sliding_panel);
        spl.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelClosed(View view) {
                SlidingPanelLayoutActivity.this.getFragmentManager()
                        .findFragmentById(R.id.leftfragment)
                        .setHasOptionsMenu(false);
            }

            @Override
            public void onPanelOpened(View viw) {
                SlidingPanelLayoutActivity.this.getFragmentManager()
                        .findFragmentById(R.id.leftfragment)
                        .setHasOptionsMenu(true);
            }

            @Override
            public void onPanelSlide(View arg0, float arg1) {

            }
        });
    }

    @Override
    public void onChangeBookmark(String bookmark) {
        ShowFragment sf = (ShowFragment) SlidingPanelLayoutActivity.this.getFragmentManager()
                .findFragmentById(R.id.rightfragment);
        WebView webView = sf.getWebView();
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.loadUrl(bookmark);
    }
}
