package jp.ac.it_college.std.s13012.httpsample;


import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndroidHttpClientAsyncTask
        extends AsyncTask<String, Void, String>{

    private Activity activity;

    public AndroidHttpClientAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        AndroidHttpClient httpClient = AndroidHttpClient.newInstance("Demo AndroidHttpClient");
        HttpResponse response = null;
        String line = "";
        String result = "";
        try {
            HttpUriRequest uri = new HttpGet(params[0]);

            response = httpClient.execute(uri);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            while ((line = br.readLine()) != null) {
                result += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        ((TextView)activity.findViewById(R.id.result))
                .setText(Html.fromHtml(result));
    }
}
