package eus.mainu.mainu.Utilidades;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import eus.mainu.mainu.R;
import eus.mainu.mainu.datalayer.Valoracion;

/**
 * Created by Manole on 08/03/2018.
 * Clase para adaptar los comentarios de los usuarios
 */

public class AdaptadorComentarios extends RecyclerView.Adapter<AdaptadorComentarios.ViewHolder> {

    //Para debuggear
    private static final String TAG = "AdaptadorComentarios";
    ArrayList<Valoracion> arrayValoraciones = new ArrayList<>();
    private Context mContext;

    public AdaptadorComentarios (ArrayList<Valoracion> arrayValoraciones, Context context) {
        this.arrayValoraciones = arrayValoraciones;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclingview_comentarios, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: Called");

        holder.comentario.setText(arrayValoraciones.get(position).getComentario());
        holder.nombre.setText(arrayValoraciones.get(position).getNombre());

        if(arrayValoraciones.get(position).getUsuario() != null){
            holder.estrellas.setRating((float) arrayValoraciones.get(position).getPuntuacion());

            if(!arrayValoraciones.get(position).getUsuario().getFoto().isEmpty()){
                Picasso.with(mContext)
                        .load(arrayValoraciones.get(position).getUsuario().getFoto())
                        .fit()
                        .into(holder.foto);
            }
        }
        else{
            Picasso.with(mContext)
                    .load(R.drawable.mainu_logo)
                    .fit()
                    .into(holder.foto);
        }


    }

    @Override
    public int getItemCount() {
        return arrayValoraciones.size();
    }

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {

        TextView comentario;
        ImageButton foto;
        TextView nombre;
        RatingBar estrellas;

        public ViewHolder(View itemView) {
            super(itemView);
            comentario = itemView.findViewById(R.id.comentarioUsuario);
            foto = itemView.findViewById(R.id.fotoUsuario);
            nombre = itemView.findViewById(R.id.nombreUsuario);
            estrellas = itemView.findViewById(R.id.puntuacionUsuario);
            //estrella = itemView.findViewById(R.id.estrella);
        }
    }


}
