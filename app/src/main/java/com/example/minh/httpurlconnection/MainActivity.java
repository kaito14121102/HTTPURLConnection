package com.example.minh.httpurlconnection;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtresult= (TextView) findViewById(R.id.txtresult);
        MyAsyn myAsyn=new MyAsyn();
        myAsyn.execute("https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json");


    }

    class MyAsyn extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String textUrl = params[0];

            InputStream in = null;
            BufferedReader br = null;
            try {
                URL url = new URL(textUrl);
                HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

                httpConn.setAllowUserInteraction(false);
                httpConn.setInstanceFollowRedirects(true);
                httpConn.setRequestMethod("GET");
                httpConn.connect();
                int resCode = httpConn.getResponseCode();

                if (resCode == HttpURLConnection.HTTP_OK) {
                    in = httpConn.getInputStream();
                    br = new BufferedReader(new InputStreamReader(in));

                    StringBuilder sb = new StringBuilder();
                    String s = null;
                    while ((s = br.readLine()) != null) {
                        sb.append(s);
                        sb.append("\n");
                    }
                    return sb.toString();
                } else {
                    return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            KhoaHoc khoaHoc = gson.fromJson(s, KhoaHoc.class);
            txtresult.setText(khoaHoc.getMonhoc()+"\n"+khoaHoc.getNoihoc());
            String s1 = gson.toJson(khoaHoc);
            txtresult.append("\n------------------------\n"+s1);
        }
    }
}
