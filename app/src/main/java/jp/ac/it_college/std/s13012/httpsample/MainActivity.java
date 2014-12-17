package jp.ac.it_college.std.s13012.httpsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import org.apache.http.client.methods.HttpGet;


public class MainActivity extends Activity {

    private String url = "http://typosone.jp/test/index.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity activity = this;

        findViewById(R.id.button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // DefaultHttpClient
                        // new DefaultHttpClientAsyncTask(activity).execute(url);

                        // AndroidHttpClient
                        new AndroidHttpClientAsyncTask(activity).execute(new HttpGet(url));
                    }
                });
    }

}
