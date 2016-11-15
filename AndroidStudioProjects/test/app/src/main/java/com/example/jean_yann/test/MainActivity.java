package com.example.jean_yann.test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),getString(R.string.texte1),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId()) {
            case R.id.toast:

                Toast.makeText(getApplicationContext(), getString(R.string.texte1), Toast.LENGTH_LONG).show();
                return true;

            case R.id.pop:
                new AlertDialog.Builder(this)
                        .setTitle("Ceci est un message d'alerte")
                        .setMessage("MDR")
                        .show();
                return true;

            case R.id.notif:

                PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
                Notification notification = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.studio)
                        .setContentTitle("Ceci est une notification")
                        .setContentText("On est trop fort !")
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification);

                return true;

            case R.id.activity:

               // Intent in = new Intent(this,SecondActivity.class);
                //startActivity(in);
                GetBiersServices.startActionBeer(this);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }



}
