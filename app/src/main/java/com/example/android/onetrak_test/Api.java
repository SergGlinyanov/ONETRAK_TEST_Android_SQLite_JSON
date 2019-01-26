package com.example.android.onetrak_test;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Api extends AsyncTask <Void,Void,Void> {



    public static String data = "";



    @Override
    protected Void doInBackground(Void... voids) {

        try {

            URL url = new URL("https://intern-f6251.firebaseio.com/intern/metric.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line ="";

            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }




        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


}
