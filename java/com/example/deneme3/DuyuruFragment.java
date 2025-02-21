package com.example.deneme3;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DuyuruFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_duyuru_fragment);
        WebView webView = findViewById(R.id.webView);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // JavaScript'i etkinleştir
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);


        webView.setWebViewClient(new WebViewClient());


        webView.loadUrl("https://www.harran.edu.tr/duylist.aspx?duyPerSay=20&sayfaNum=0");
    }
}