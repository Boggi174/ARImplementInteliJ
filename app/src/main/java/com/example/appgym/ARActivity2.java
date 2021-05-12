package com.example.appgym;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
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

public class ARActivity2 extends AppCompatActivity {

    private ArFragment arFragment;
    private ModelRenderable modelRenderable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_ar);

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
    ViewRenderable glut_button;
    ViewRenderable abs_button;

    // Asignacion de partes interactuables
    private void addParts(AnchorNode anchorNode, TransformableNode node, String name){

        /**
         * Generacion de botones al rededor del modelo 3D
         */

        /** Agrega Pecho **/
        TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView.setLocalPosition(new Vector3(node.getLocalPosition().x+0.0f, node.getLocalPosition().y +0.65f,node.getLocalPosition().z+0.1f));
        nameView.setParent(anchorNode);
        nameView.setRenderable(chest_button);
        nameView.select();

        /** Agrega Brazos **/
        TransformableNode nameView2 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView2.setLocalPosition(new Vector3(node.getLocalPosition().x+0.12f, node.getLocalPosition().y +0.55f,node.getLocalPosition().z+0.1f));
        nameView2.setParent(anchorNode);
        nameView2.setRenderable(arms_button);
        nameView2.select();

        /** Agrega Piernas **/
        TransformableNode nameView3 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView3.setLocalPosition(new Vector3(node.getLocalPosition().x+0.08f, node.getLocalPosition().y +0.08f,node.getLocalPosition().z+0.1f));
        nameView3.setParent(anchorNode);
        nameView3.setRenderable(legs_button);
        nameView3.select();

        /** Agrega Espalda **/
        TransformableNode nameView4 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView4.setLocalPosition(new Vector3(node.getLocalPosition().x+0.0f, node.getLocalPosition().y +0.65f,node.getLocalPosition().z-0.1f));
        nameView4.setParent(anchorNode);
        nameView4.setRenderable(back_button);
        nameView4.select();

        /** Agrega Gluteo**/
        TransformableNode nameView5 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView5.setLocalPosition(new Vector3(node.getLocalPosition().x+0.0f, node.getLocalPosition().y +0.4f,node.getLocalPosition().z-0.1f));
        nameView5.setParent(anchorNode);
        nameView5.setRenderable(glut_button);
        nameView5.select();


        /** Agrega Abs**/
        TransformableNode nameView6 = new TransformableNode(arFragment.getTransformationSystem());
        // Esta linea permite mover la ubicacion de la generacion del clikcable
        nameView6.setLocalPosition(new Vector3(node.getLocalPosition().x+0.0f, node.getLocalPosition().y +0.43f,node.getLocalPosition().z+0.10f));
        nameView6.setParent(anchorNode);
        nameView6.setRenderable(abs_button);
        nameView6.select();

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

        ViewRenderable.builder()
                .setView(this, R.layout.gluteus_button)
                .build()
                .thenAccept(renderable -> glut_button = renderable );
        ViewRenderable.builder()
                .setView(this, R.layout.abs_button)
                .build()
                .thenAccept(renderable -> abs_button = renderable );
        ModelRenderable.builder()
                .setSource(this, R.raw.femalefinal)
                .build()
                .thenAccept(renderable->modelRenderable = renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(ARActivity2.this, "Model can't be Loaded", Toast.LENGTH_SHORT).show();
                    return null;
                });


       }



    public void openChest(View view){
        Intent intent = new Intent(this, Main_Recyclerview_pectoral.class);
        startActivity(intent);
    }

    public void openLegs(View view){
        Intent intent = new Intent(this, Main_Recyclerview_pierna.class);
        startActivity(intent);
    }

    public void openBack(View view){
        Intent intent = new Intent(this, Main_Recyclerview_espalda.class);
        startActivity(intent);
    }

    public void openArms(View view){
        Intent intent = new Intent(this, Main_Recyclerview_brazo.class);
        startActivity(intent);
    }

    public void openGlut(View view){
        Intent intent = new Intent(this,Main_Recyclerview_gluteo.class);
        startActivity(intent);

    }

    public void openAbs(View view){
        Intent intent = new Intent(this,Main_Recyclerview_abdomen.class);
        startActivity(intent);
    }



}