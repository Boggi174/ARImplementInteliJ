package com.example.appgym;

import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

public class Rutina_pectorales extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutina_pectorales);
        //ESTA FUNCIONALIDAD NOS PERMITE QUE SI SE DA CLIC EN OTRAS VISTAS TE REDIRIGA AQUI DEPENDIENDO DE LA FUNCIÓN
        Bundle bundle = getIntent().getExtras();

        //VALIDACIÓN PARA DETERMINAR SI HAY UN PROBLEMA
        if(bundle != null){
            if(bundle.getString("some")!=null){
                Toast.makeText(getApplicationContext(),"data:" + bundle.getString("some"), Toast.LENGTH_SHORT);
            }

        }

        //ESTE CODIGO ES PARA AGREGAR UN VIDEO DE YOUTUBE
        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull final YouTubePlayer initializedYoutubePlayer) {
                initializedYoutubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        String videoId= "Vq5ZAQCP49Y";
                        initializedYoutubePlayer.loadVideo(videoId,0);
                    }
                });
            }
        }, true);

    }
}