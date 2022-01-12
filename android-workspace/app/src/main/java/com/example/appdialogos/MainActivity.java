package com.example.appdialogos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence[] elementos = {"CASO 0", "CASO 1", "CASO 3", "CASO 4", "CASO 5"};
        CharSequence[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        ArrayList<Integer> itemsSeleccionados= new ArrayList<>();

        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("EJEMPLO DE DIÁLOGO")
                        .setTitle("TITULO DE DIÁLOGO")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setPositiveButton("PRIMERO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "PRIMERO", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("SEGUNDO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "SEGUNDO", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("TERCERO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "TERCERO", Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialogo = builder.create();
                dialogo.show();
            }
        });
        Button boton2 = findViewById(R.id.button2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("TITULO DE DIÁLOGO")
                        .setIcon(android.R.drawable.btn_star_big_on)
                        .setItems(elementos, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "Selecionaste: " + elementos[id], Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialogo = builder.create();
                dialogo.show();
            }
        });
        Button boton3 = findViewById(R.id.button3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("TITULO DE DIÁLOGO")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(elementos, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this, "Seleccionaste: " + elementos[id], Toast.LENGTH_SHORT).show();
                            }
                        });
                AlertDialog dialogo= builder.create();
                dialogo.show();
            }
        });
        Button boton4 = findViewById(R.id.button4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("DIAS DE LA SEMANA")
                        .setIcon(android.R.drawable.checkbox_on_background)
                        .setMultiChoiceItems(dias, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if(isChecked){
                                    //Guardar índice seleccionado
                                    itemsSeleccionados.add(which);
                                    Toast.makeText(MainActivity.this, "Checks seleccionados:(" + itemsSeleccionados.size() + ")", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Remover índice sini selección
                                    itemsSeleccionados.remove(which);
                                    Toast.makeText(MainActivity.this, "Checks seleccionados:("+itemsSeleccionados.size()+")", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                AlertDialog dialogo= builder.create();
                dialogo.show();
            }
        });
    }
}