package com.example.appgym;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import org.jetbrains.annotations.NotNull;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder>
{

    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }
    //AQUI ES PARA QUE TE TRAEGA TODOS LA INFORMACIÓN DE UN REGISTRO DE TU TABLA
    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.rutina_name.setText(model.getN_rutina());



        holder.rutina_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.recycler_view,new Visualizar_info_rutina(model.getN_rutina(),model.getDes_rutina(),model.getId_video())).addToBackStack(null).commit();

            }
        });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder(view);
    }
    //AQUI ES PARA QUE TE MUESTRE EL NOMBRE DEL LISTADO DE TODOS LOS EJERCICIOS DE LA TABLA
    public class myviewholder extends RecyclerView.ViewHolder {
        TextView rutina_name;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            rutina_name=itemView.findViewById(R.id.rutinatext);
        }
    }
}
