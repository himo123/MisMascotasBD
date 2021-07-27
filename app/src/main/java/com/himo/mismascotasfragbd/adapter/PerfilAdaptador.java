package com.himo.mismascotasfragbd.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.himo.mismascotasfragbd.pojo.Mascota;
import com.himo.mismascotasfragbd.R;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    ArrayList<Mascota> mascotas;
    Activity contexto;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity contexto) {
        this.mascotas = mascotas;
        this.contexto = contexto;
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgFotoPerfil;
        private final TextView tvRatingCVPerfil;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFotoPerfil = itemView.findViewById(R.id.imgFotoPerfil);
            tvRatingCVPerfil = itemView.findViewById(R.id.tvRatingCVPerfil);
        }
    }

    @NonNull  @Override  //Inflar el layout y los pasa al ViewHolder para que obtenga los views
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflar = LayoutInflater.from(parent.getContext());
        View elemento = inflar.inflate(R.layout.cardview_perfil, parent, false);
        return new PerfilViewHolder(elemento);
    }

    @Override  //asocia cada elemento de la lista con cada view
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFotoPerfil.setImageResource(mascota.getFoto());
        holder.tvRatingCVPerfil.setText(String.valueOf(mascota.getRating()));
    }

    @Override
    public int getItemCount() {  //Cantidad de elementos que contiene la lista
        return mascotas.size();
    }

}
