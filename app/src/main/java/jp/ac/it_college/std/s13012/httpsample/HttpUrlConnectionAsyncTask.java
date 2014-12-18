package jp.ac.it_college.std.s13012.httpsample;


import android.app.Activity;
import android.os.AsyncTask;
import android.text.Html;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionAsyncTask
        extends AsyncTask<String, Void, String> {

    private Activity activity;

    public HttpUrlConnectionAsyncTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        String line = "";
        String result = "";
        try {
            // 仮引数からURLオブジェクトを作成
            URL url = new URL(params[0]);
            // 接続用HttpURLConnectionオブジェクト作成
            connection = (HttpURLConnection) url.openConnection();
            // リクエストメソッドの設定
            connection.setRequestMethod("GET");
            // リダイレクトを自動で許可しない設定
            connection.setInstanceFollowRedirects(false);
            // ヘッダーの設定(複数設定可能)
            connection.setRequestProperty("Accept-Language", "jp");
            // 接続
            connection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));

            // htmlのbody部分を取得
            while ((line = br.readLine()) != null) {
                result += line;
            }

            br.close();
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
