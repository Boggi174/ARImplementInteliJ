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
import com.example.appgym.*;
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
                Intent in = new Intent(getActivity(), Main_Recyclerview_pectoral.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL TEXTO  TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_pectoral = (TextView) root.findViewById(R.id.label_pectoral);
        text_pectoral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_pectoral.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        ImageView abdomen = (ImageView) root.findViewById(R.id.img_abdomen);
        abdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_abdomen.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL TEXTO  TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_abdomen = (TextView) root.findViewById(R.id.label_abdomen);
        text_abdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_abdomen.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        ImageView brazo = (ImageView) root.findViewById(R.id.img_brazo);
        brazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_brazo.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL TEXTO  TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_brazo = (TextView) root.findViewById(R.id.label_brazo);
        text_brazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_brazo.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        ImageView espalda = (ImageView) root.findViewById(R.id.img_espalda);
        espalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_espalda.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL TEXTO  TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_espalda = (TextView) root.findViewById(R.id.label_espalda);
        text_espalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_espalda.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        ImageView pierna = (ImageView) root.findViewById(R.id.img_pierna);
        pierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_pierna.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL TEXTO  TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_pierna = (TextView) root.findViewById(R.id.label_pierna);
        text_pierna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_pierna.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN LA IMAGEN TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        ImageView gluteo = (ImageView) root.findViewById(R.id.img_gluteo);
        gluteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_gluteo.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL TEXTO TE REDIRIGA EN LA VISTA SELECCIONA (.CLASS)
        TextView text_gluteo = (TextView) root.findViewById(R.id.label_gluteo);
        text_gluteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Main_Recyclerview_gluteo.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });


        return root;
    }
}