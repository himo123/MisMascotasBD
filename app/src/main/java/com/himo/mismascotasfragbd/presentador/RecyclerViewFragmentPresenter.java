package com.himo.mismascotasfragbd.presentador;

import android.content.Context;

import com.himo.mismascotasfragbd.db.ConstructorMascotas;
import com.himo.mismascotasfragbd.vista.IRecyclerViewFragmentVista;
import com.himo.mismascotasfragbd.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentVista iRecyclerViewFragmentVista;
    private Context contexto;
    private ArrayList<Mascota> mascotas;
    private ConstructorMascotas constructorMascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentVista iRecyclerViewFragmentVista, Context contexto) {
        this.iRecyclerViewFragmentVista = iRecyclerViewFragmentVista;
        this.contexto = contexto;
        obtenerMascotasBD();
    }

    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(contexto);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentVista.inicializarAdaptadorRV(iRecyclerViewFragmentVista.crearAdaptador(mascotas));
        iRecyclerViewFragmentVista.generarLinearLayoutVertical();
    }

}
