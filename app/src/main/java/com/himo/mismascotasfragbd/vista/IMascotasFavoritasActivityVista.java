package com.himo.mismascotasfragbd.vista;

import com.himo.mismascotasfragbd.adapter.MascotaAdaptador;
import com.himo.mismascotasfragbd.pojo.Mascota;
import java.util.ArrayList;

public interface IMascotasFavoritasActivityVista {

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

    public void generarLinearLayoutVertical();

}
