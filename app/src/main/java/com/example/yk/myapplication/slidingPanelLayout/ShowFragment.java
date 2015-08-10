package com.example.yk.myapplication.slidingPanelLayout;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.yk.myapplication.R;

/**
 * Created by yk on 15/8/10.
 */
public class ShowFragment extends Fragment {
    WebView webview=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.show, container, false);
        webview=(WebView) view.findViewById(R.id.webview);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public WebView getWebView()
    {
        return webview;
    }
}
