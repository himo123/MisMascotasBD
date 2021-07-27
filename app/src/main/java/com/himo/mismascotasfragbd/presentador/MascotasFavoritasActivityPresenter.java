package com.himo.mismascotasfragbd.presentador;

import android.content.Context;

import com.himo.mismascotasfragbd.db.ConstructorMascotas;
import com.himo.mismascotasfragbd.pojo.Mascota;
import com.himo.mismascotasfragbd.vista.IMascotasFavoritasActivityVista;
import com.himo.mismascotasfragbd.vista.IRecyclerViewFragmentVista;
import java.util.ArrayList;

public class MascotasFavoritasActivityPresenter implements IMascotasFavoritasActivityPresenter{
    private IMascotasFavoritasActivityVista iMascotasFavoritasActivityVista;
    private Context contexto;
    private ArrayList<Mascota> mascotasFavoritas;
    private ConstructorMascotas constructorMascotas;

    public MascotasFavoritasActivityPresenter(IMascotasFavoritasActivityVista iMascotasFavoritasActivityVista, Context contexto) {
        this.iMascotasFavoritasActivityVista = iMascotasFavoritasActivityVista;
        this.contexto =  contexto;
        obtenerMascotasFavoritasBD();
    }

    @Override
    public void obtenerMascotasFavoritasBD() {
        constructorMascotas = new ConstructorMascotas(contexto);
        mascotasFavoritas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasFavoritasRV();
    }

    @Override
    public void mostrarMascotasFavoritasRV() {
        iMascotasFavoritasActivityVista.inicializarAdaptadorRV(iMascotasFavoritasActivityVista.crearAdaptador(mascotasFavoritas));
        iMascotasFavoritasActivityVista.generarLinearLayoutVertical();
    }

}
