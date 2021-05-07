package com.example.appgym;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;

public class Main_Recyclerview_brazo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__recyclerview_pectoral);
        //ESTA FUNCIONALIDAD NOS PERMITE QUE SI SE DA CLIC EN OTRAS VISTAS TE REDIRIGA AQUI DEPENDIENDO DE LA FUNCIÓN
        Bundle bundle = getIntent().getExtras();

        //VALIDACIÓN PARA DETERMINAR SI HAY UN PROBLEMA
        if(bundle != null){
            if(bundle.getString("some")!=null){
                Toast.makeText(getApplicationContext(),"data:" + bundle.getString("some"), Toast.LENGTH_SHORT);
            }

        }
        //ESTA FUNCIONALIDAD SIRVE PARA QUE TE LLEVE AL FRAGMENT PARA QUE HAGA LA CONSULTA Y TE TRAEGA LA INFIRMACIÓN DE LA BD
        getSupportFragmentManager().beginTransaction().replace(R.id.recycler_view,new recfragment_brazo()).commit();

    }
}