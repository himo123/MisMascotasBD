package com.himo.mismascotasfragbd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.himo.mismascotasfragbd.db.ConstructorMascotas;
import com.himo.mismascotasfragbd.pojo.Mascota;
import com.himo.mismascotasfragbd.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    ArrayList<Mascota> mascotas;
    Activity contexto;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity contexto) {
        this.mascotas = mascotas;
        this.contexto = contexto;
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgFoto;
        private final ImageButton btnLike;
        private final TextView tvNombreCV;
        private final TextView tvRatingCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            btnLike = itemView.findViewById(R.id.btnLike);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvRatingCV = itemView.findViewById(R.id.tvRatingCV);
        }
    }

    @NonNull  @Override  //Inflar el layout y los pasa al ViewHolder para que obtenga los views
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflar = LayoutInflater.from(parent.getContext());
        View elemento = inflar.inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(elemento);
    }

    @Override  //asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombreCV.setText(mascota.getNombre());
        holder.tvRatingCV.setText(String.valueOf(mascota.getRating()));

//        //Mostrar la información de una mascota
//        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(contexto, "Mascota: " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
//                Intent intento = new Intent(v.getContext(), PerfilFragment.class);
//                intento.putExtra(v.getContext().getResources().getString(R.string.pnombre), contacto.getNombre());
//                intento.putExtra(v.getContext().getResources().getString(R.string.ptelefono), contacto.getTelefono());
//                intento.putExtra(v.getContext().getResources().getString(R.string.pemail), contacto.getEmail());
//                v.getContext().startActivity(intento);
//            }
//        });

        holder.btnLike.setOnClickListener(v -> {
            if (holder.btnLike.getVisibility() == View.VISIBLE) {
//                mascota.setRating(mascota.getRating() + 1);
//                holder.tvRatingCV.setText(String.valueOf(mascota.getRating()));
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(contexto);
                constructorMascotas.insertarRatingMascota(mascota);
                holder.tvRatingCV.setText(String.valueOf(constructorMascotas.obtenerRatingsMascota(mascota)));
            }
        });
    }

    @Override
    public int getItemCount() {  //Cantidad de elementos que contiene la lista
        return mascotas.size();
    }

}
