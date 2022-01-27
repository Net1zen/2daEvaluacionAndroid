package com.rubenarriazu.hilos1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setMax(100);

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        progressBar.post(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setMin(0);
                            }
                        });

                        for (int i = 0; i < 10; i++) {
                            tareaLarga();
                            progressBar.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.incrementProgressBy(10);
                                }
                            });
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "Tarea completada",
                                        Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                }).start();
            }
        });
    }

    private void tareaLarga() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}