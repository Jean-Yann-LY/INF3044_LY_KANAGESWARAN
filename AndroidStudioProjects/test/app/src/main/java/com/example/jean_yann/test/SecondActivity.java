package com.example.jean_yann.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {
   // RecyclerView rv = (RecyclerView) findViewById(R.id.rv_biere);


   // public static final String BIERS_UPDATE = "B";
     public static final String BIERS_UPDATE = "com.octip.cours.inf4042_11BIERS_UPDATE";
    private BieresAdapter mAdapter;
    private RecyclerView rvbiere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rvbiere = (RecyclerView)findViewById(R.id.rv_biere);
        mAdapter = new BieresAdapter(getBiersFromFile());
        rvbiere.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rvbiere.setAdapter(mAdapter);
        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(),intentFilter);


    }

    public class BierUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context , Intent intent){
            //Log.d("download",getIntent().getAction());
            Toast.makeText(getApplicationContext(), getString(R.string.download), Toast.LENGTH_LONG).show();
            mAdapter.setNewBiere(getBiersFromFile());
            rvbiere.getAdapter();

        }
    }

    public JSONArray getBiersFromFile(){
        try{
            InputStream is = new FileInputStream(getCacheDir()+"/"+"bieres.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONArray(new String(buffer,"UTF-8"));
        }
        catch (IOException e){
            e.printStackTrace();
            return new JSONArray();
        }
        catch (JSONException e){
            e.printStackTrace();
            return new JSONArray();
        }
    }




}

