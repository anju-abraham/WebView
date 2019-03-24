package com.example.user.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);

       webView.loadUrl("https://www.google.com");

        //Loading HTML Directly Into a WebView With loadData()
       // webView.loadData("<html><body>Hello, world!</body></html>", "text/html", "UTF-8");


//        //Loading HTML Into a WebView With a Base URL
//        String baseUrl    = "https://www.journaldev.com";
//        String data       = "Relative Link";
//        String mimeType   = "text/html";
//        String encoding   = "UTF-8";
//        String historyUrl = "https://www.journaldev.com";
//        webView.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.webView.canGoBack()) {
            this.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

}