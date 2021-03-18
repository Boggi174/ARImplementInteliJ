package com.example.myapplication;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private ModelRenderable modelRenderable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment= (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        setUpModel();
        setUpPlane();

    }

    // Seleccion del plano donde se va a poner el modelo 3D
    private void setUpPlane() {
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode);
            }
        });
    }


    //Creacion del modelo 3D
    private void createModel(AnchorNode anchorNode){
        TransformableNode node = new TransformableNode(arFragment.getTransformationSystem());
        node.setParent(anchorNode);
        node.setRenderable(modelRenderable);
        node.select();
         addParts(anchorNode, node, "Chest");


    }

    ViewRenderable chest_button;
    ViewRenderable arms_button;
    ViewRenderable back_button;
    ViewRenderable legs_button;

    // Asignacion de partes interactuables
    private void addParts(AnchorNode anchorNode, TransformableNode node, String name){

        /**
         * Generacion de botones al rededor del modelo 3D
         */

        /** Agrega Pecho **/
        TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView.setLocalPosition(new Vector3(node.getLocalPosition().x+0.0f, node.getLocalPosition().y +0.25f,node.getLocalPosition().z+0.04f));
        nameView.setParent(anchorNode);
        nameView.setRenderable(chest_button);
        nameView.select();

        /** Agrega Brazos **/
        TransformableNode nameView2 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView2.setLocalPosition(new Vector3(node.getLocalPosition().x+0.055f, node.getLocalPosition().y +0.25f,node.getLocalPosition().z+0.012f));
        nameView2.setParent(anchorNode);
        nameView2.setRenderable(arms_button);
        nameView2.select();

        /** Agrega Piernas **/
        TransformableNode nameView3 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView3.setLocalPosition(new Vector3(node.getLocalPosition().x+0.035f, node.getLocalPosition().y +0.05f,node.getLocalPosition().z+0.015f));
        nameView3.setParent(anchorNode);
        nameView3.setRenderable(legs_button);
        nameView3.select();

        /** Agrega Espalda **/
        TransformableNode nameView4 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView4.setLocalPosition(new Vector3(node.getLocalPosition().x+0.0f, node.getLocalPosition().y +0.25f,node.getLocalPosition().z-0.04f));
        nameView4.setParent(anchorNode);
        nameView4.setRenderable(back_button);
        nameView4.select();

    }

    // Se hace un setup del modelo que se va a utilizar
    private void setUpModel() {

        ViewRenderable.builder()
                .setView(this, R.layout.chest_button)
                .build()
                .thenAccept(renderable -> chest_button = renderable );

        ViewRenderable.builder()
                .setView(this, R.layout.arms_button)
                .build()
                .thenAccept(renderable -> arms_button = renderable );

        ViewRenderable.builder()
                .setView(this, R.layout.back_button)
                .build()
                .thenAccept(renderable -> back_button = renderable );

        ViewRenderable.builder()
                .setView(this, R.layout.legs_button)
                .build()
                .thenAccept(renderable -> legs_button = renderable );

        ModelRenderable.builder()
                .setSource(this, R.raw.malefinal)
                .build()
                .thenAccept(renderable->modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(MainActivity.this, "Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });
    }

    public void openChest(View view){
        Intent intent = new Intent(this, ChestActivity.class);
        startActivity(intent);
    }

    public void openLegs(View view){
        Intent intent = new Intent(this, LegsActivity.class);
        startActivity(intent);
    }

    public void openBack(View view){
        Intent intent = new Intent(this, BackActivity.class);
        startActivity(intent);
    }

    public void openArms(View view){
        Intent intent = new Intent(this, ArmsActivity.class);
        startActivity(intent);
    }
}