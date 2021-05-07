package com.example.appgym;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.player.listeners.YouTubePlayerInitListener;

public class Visualizar_info_rutina extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    String n_rutina,des_rutina,id_video;

    public Visualizar_info_rutina() {
    }

    public Visualizar_info_rutina(String n_rutina,String des_rutina,String id_video) {
        this.n_rutina=n_rutina;
        this.des_rutina=des_rutina;
        this.id_video=id_video;
    }



    public static Visualizar_info_rutina newInstance(String param1, String param2) {
        Visualizar_info_rutina fragment = new Visualizar_info_rutina();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_visualizar_info_rutina, container, false);

        TextView rutina_name = view.findViewById(R.id.rutina_text);
        TextView des_rutina_text = view.findViewById(R.id.des_rutinatext);

        rutina_name.setText(n_rutina);
        des_rutina_text.setText(des_rutina);


        //ESTE CODIGO ES PARA AGREGAR UN VIDEO DE YOUTUBE
        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.id_video_text);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull final YouTubePlayer initializedYoutubePlayer) {
                initializedYoutubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        String videoId= id_video;
                        initializedYoutubePlayer.loadVideo(videoId,0);
                    }
                });
            }
        }, true);


        return view;
    }



    public void onBackPressed(){
        AppCompatActivity activity = (AppCompatActivity)getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.recycler_view,new recfragment_pectoral()).addToBackStack(null).commit();

    }

}