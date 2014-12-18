package jp.ac.it_college.std.s13012.httpsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener {

    private String url = "http://typosone.jp/test/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                // DefaultHttpClient
                // new DefaultHttpClientAsyncTask(this).execute(url);

                // AndroidHttpClient
                //new AndroidHttpClientAsyncTask(this).execute(new HttpGet(url));

                // HttpUrlConnection
                new HttpUrlConnectionAsyncTask(this).execute(url);

                break;
        }
    }
}
