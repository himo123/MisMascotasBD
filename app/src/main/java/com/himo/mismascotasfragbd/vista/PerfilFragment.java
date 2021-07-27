package com.himo.mismascotasfragbd.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.himo.mismascotasfragbd.R;
import com.himo.mismascotasfragbd.adapter.PerfilAdaptador;
import com.himo.mismascotasfragbd.pojo.Mascota;
import com.himo.mismascotasfragbd.pojo.MisMascotas;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.Collections;

public class PerfilFragment extends Fragment {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    ArrayList<Mascota> unaMascota = new ArrayList<>();
    private RecyclerView rvPerfilMascota;
    private CircularImageView civFotoPerfil;
    private TextView tvNombrePerfil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfilMascota = v.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvPerfilMascota.setLayoutManager(glm);

        civFotoPerfil = v.findViewById(R.id.civFotoPerfil);
        tvNombrePerfil = v.findViewById(R.id.tvNombrePerfil);

        return v;
    }

    //inicializo la lista y el adaptador en este método para que cada vez que
    //se abra el fragment, muestre una mascota diferente a la anterior
    @Override
    public void onResume() {
        super.onResume();
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas() {
        MisMascotas Mm = new MisMascotas();
        unaMascota = Mm.soloUnaMascota(100);
        civFotoPerfil.setImageResource(unaMascota.get(0).getFoto());
        tvNombrePerfil.setText(String.valueOf(unaMascota.get(0).getNombre()));
        Collections.sort(unaMascota);
    }

    public void inicializarAdaptador() {
        PerfilAdaptador adaptador = new PerfilAdaptador(unaMascota, getActivity());
        rvPerfilMascota.setAdapter(adaptador);
    }
}
