package jp.ac.it_college.std.s13012.httpsample;


import android.app.Activity;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DefaultHttpClientAsyncTask extends AsyncTask<String, Void, String> {

    private Activity activity;

    public DefaultHttpClientAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        String line = "";
        String result = "";

        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(params[0]);
            HttpResponse response = client.execute(request);

            // Get the response
            BufferedReader rd = new BufferedReader
                    (new InputStreamReader(response.getEntity().getContent()));

            while ((line = rd.readLine()) != null) {
                result += line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    protected void onPostExecute(String result) {
        ((TextView) activity.findViewById(R.id.result))
                .setText(Html.fromHtml(result));
    }
}
