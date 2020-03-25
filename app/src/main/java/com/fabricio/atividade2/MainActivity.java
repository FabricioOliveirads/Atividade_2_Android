package com.fabricio.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> paises = new ArrayList<>() ;
    private ListView listapaies;
    private Button carregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listapaies = (ListView) findViewById(R.id.listaPaises);
        carregar = (Button) findViewById(R.id.btncarregar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                paises.add(new RemoteFetch().getJSON().toString());

            }
        }).start();
        carregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listapaies.setAdapter(new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        paises
                ));

            }
        });

    }
}
