package com.example.appgym;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class EsqueletoWoman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueleto_woman);

        Bundle bundle = getIntent().getExtras();
        //VALIDACIÓN PARA DETERMINAR SI HAY UN PROBLEMA
        if(bundle != null){
            if(bundle.getString("some")!=null){
                Toast.makeText(getApplicationContext(),"data:" + bundle.getString("some"), Toast.LENGTH_SHORT);
            }
        }
    }

    public void openArw(View view){
        Intent intent = new Intent(this, ARActivity2.class);
        startActivity(intent);
    }
}