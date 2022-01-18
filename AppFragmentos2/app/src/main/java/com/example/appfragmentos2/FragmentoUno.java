package com.example.appfragmentos2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoUno extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflamos el layout para este fragmento

        //Primero guardamos la vista que me infla y al final la devolvemos
        View view = inflater.inflate(R.layout.fragment_layout_1, container, false);
        Button btn = (Button) view.findViewById(R.id.boton1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Se ha pulsado el framento 1", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
