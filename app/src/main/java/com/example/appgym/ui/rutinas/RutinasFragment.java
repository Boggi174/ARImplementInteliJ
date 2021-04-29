package com.example.appgym.ui.rutinas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.appgym.Rutina_pectorales;
import com.example.myapplication.R;

public class RutinasFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rutinas, container, false);

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        ImageView pectoral = (ImageView) root.findViewById(R.id.img_pectoral);
        pectoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Rutina_pectorales.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_pectoral = (TextView) root.findViewById(R.id.label_pectorales);
        text_pectoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Rutina_pectorales.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });




        return root;
    }
}