package tut.ac.za.tvep;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tut.ac.za.tvep.classes.AppConstants;
import tut.ac.za.tvep.classes.Info;

public class WebActivity extends AppCompatActivity {

    @BindView(R.id.web)
    WebView web;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);



        Intent intent = getIntent();

        Info info = (Info) intent.getSerializableExtra(AppConstants.INFO);



        ButterKnife.bind(this);

        setTitle("Information");

        web.loadUrl(info.getUrl());
        WebSettings webla = web.getSettings();
        webla.setJavaScriptEnabled(true);
    }
}
