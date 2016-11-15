package com.example.jean_yann.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

   // public static final String BIERS_UPDATE = "B";
     public static final String BIERS_UPDATE = "com.octip.cours.inf4042_11BIERS_UPDATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        IntentFilter intentFilter = new IntentFilter(BIERS_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new BierUpdate(),intentFilter);
    }

    public class BierUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context , Intent intent){
            //Log.d("download",getIntent().getAction());
            Toast.makeText(getApplicationContext(), getString(R.string.texte1), Toast.LENGTH_LONG).show();
        }
    }


}
