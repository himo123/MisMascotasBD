package com.himo.mismascotasfragbd.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.himo.mismascotasfragbd.R;
import com.himo.mismascotasfragbd.adapter.MascotaAdaptador;
import com.himo.mismascotasfragbd.pojo.Mascota;
import com.himo.mismascotasfragbd.presentador.IRecyclerViewFragmentPresenter;
import com.himo.mismascotasfragbd.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentVista {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO
    private IRecyclerViewFragmentPresenter presentador;
    ArrayList<Mascota> mascotas = new ArrayList<>();
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotas);
        presentador = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }

//    public void inicializarListaMascotas() {
//        //Inicializa el ArrayList con los datos de las mascotas
//        MisMascotas Mm = new MisMascotas();
//        mascotas = Mm.misMascotas();
//    }


    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public void generarLinearLayoutHorizontal() {
        //Layout para ver las mascotas en forma de grid
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        rvMascotas.setLayoutManager(glm);

    }
}
