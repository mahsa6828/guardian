package com.example.guardian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class NewsActivity extends AppCompatActivity {
    WebView webView;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        webView = findViewById(R.id.webView);
        bundle = getIntent().getExtras();
        String webUrl = bundle.getString("webUrl");
        webView.loadUrl(webUrl);
    }
}