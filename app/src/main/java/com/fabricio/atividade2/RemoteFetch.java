package com.fabricio.atividade2;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoteFetch {
    public JSONArray getJSON(){
        try {
            URL url = new URL("https://restcountries.eu/rest/v2/lang/pt");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream())
            );
            StringBuffer json = new StringBuffer(1024);
            String tmp = "";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();
                JSONArray data = new JSONArray(json.toString());

               return data;


        }catch(Exception e){
            System.err.println(e);
            return null;
        }
    }
}
