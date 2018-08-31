package com.thepensionapp.salondigitals;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by ekaranja on 4/14/18.
 */

public class SalonRegistrationWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;
    public SalonRegistrationWorker(Context ctx){
        context=ctx;

    }

    @Override
    protected String doInBackground(String... params) {

        String path="salonReg3";
        String serviceUrl=SalonUtil.getUrl()+path;
        try {
            URL url=new URL(serviceUrl);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
            String postData= URLEncoder.encode("salonLocation","UTF-8")+"="+URLEncoder.encode(params[2],"UTF-8")+"&"
                    +URLEncoder.encode("salonName","UTF-8")+"="+URLEncoder.encode(params[0],"UTF-8")+"&"
                    +URLEncoder.encode("salonPhoneNumber","UTF-8")+"="+URLEncoder.encode(params[1],"UTF-8")+"&"
                    +URLEncoder.encode("emailAddress","UTF-8")+"="+URLEncoder.encode(params[4],"UTF-8")+"&"
                    +URLEncoder.encode("numberOfEmployees","UTF-8")+"="+URLEncoder.encode(params[3],"UTF-8");
            bufferedWriter.write(postData);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            //read response from the server
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="",line="";
            while((line=bufferedReader.readLine()) !=null){
                result+=line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return  result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
            return  null;
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }

    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Salon Registration Status");

    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
