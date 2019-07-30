package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {
WebView wvMyPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        wvMyPage=findViewById(R.id.webViewMyPage);
        wvMyPage.setWebViewClient(new WebViewClient());
        WebSettings testing=wvMyPage.getSettings();
        testing.setCacheMode(WebSettings.LOAD_NO_CACHE);
        testing.setAllowFileAccess(false);
        testing.setJavaScriptEnabled(true);
        Intent intentReceived = getIntent();
        String finale=intentReceived.getStringExtra("url");

        testing.setBuiltInZoomControls(true);

        wvMyPage.loadUrl(finale);

    }
}
