package com.example.appdatepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Calendar calen = Calendar.getInstance();
        int year = calen.get(Calendar.YEAR);
        int month = calen.get(Calendar.MONTH);
        int day = calen.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog fecha = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            }
        },year,month,day);
        fecha.show();

        //TimePickerDialog
        int hour = calen.get(Calendar.HOUR_OF_DAY);
        int minute = calen.get(Calendar.MINUTE);
        TimePickerDialog hora = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            }
        }, hour, minute, false);
        hora.show();
    }
}