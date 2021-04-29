package com.example.appgym.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.appgym.EsqueletoMen;
import com.example.appgym.EsqueletoWoman;
import com.example.myapplication.R;

public class HomeFragment extends Fragment {


    //ESTA FUNCION SIRVE PARA QUE TE MUESTRE OTRA VISTA ( CUERPO HUMANO  DEL HOMBRE)
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL BOTON UBICADO EN LA POSICIÓN DEL HOMBRE
        //TE REDIRIGA AL APARTADO DEL ESQUELETO DEL HOMBRE
        Button btn_mostrar = (Button) root.findViewById(R.id.btn_mostrar);
        btn_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), EsqueletoMen.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        //ESTA ES LA FUNCIONALIDAD PARA QUE AL MOMENTO DE DAR CLIC EN EL BOTON UBICADO EN LA POSICIÓN DE LA MUJER
        //TE REDIRIGA AL APARTADO DEL ESQUELETO DE LA MUJER
        Button btn_mostrar2 = (Button) root.findViewById(R.id.btn_mostrar2);
        btn_mostrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), EsqueletoWoman.class);
                in.putExtra("some","something");
                startActivity(in);
            }
        });

        return root;
    }
}


