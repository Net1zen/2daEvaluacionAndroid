package com.example.appnotifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {

    private String canalID = "MiCanal01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createCanal();
        notificationBuilder();
    }

    // Crear notificacion
    private void notificationBuilder() {
        NotificationCompat.Builder creador = new NotificationCompat.Builder(getApplicationContext(), canalID);
        creador.setSmallIcon(android.R.drawable.stat_sys_warning);
        creador.setContentTitle("Notificacion de Android");
        creador.setContentText("Esto es un ejemplo de notificación");
        creador.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // assignActionToPendingIntent()
        // Establecer la actividad de destino
        Intent i = new Intent(MainActivity.this, MainActivity2.class);

        PendingIntent pI = PendingIntent.getActivity
                (getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        creador.setContentIntent(pI);

        // Construir y lanzar la notificación
        int notifiacionID = 0;
        NotificationManagerCompat notification = NotificationManagerCompat.from(getApplicationContext());
        notification.notify(notifiacionID, creador.build());
    }

    // Construir canal
    public void createCanal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence canalNombre = "Notificacion";
            NotificationChannel miCanal = new NotificationChannel(canalID, canalNombre, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificador.createNotificationChannel(miCanal);
        }
    }
}