package com.himo.mismascotasfragbd.db;

import android.content.ContentValues;
import android.content.Context;

import com.himo.mismascotasfragbd.R;
import com.himo.mismascotasfragbd.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;

public class ConstructorMascotas {
    private static final int RATING = 1;
    private Context contexto;

    public ConstructorMascotas(Context contexto) {
        this.contexto = contexto;
    }

    public ArrayList<Mascota> obtenerDatos() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        BaseDatos db = new BaseDatos(contexto);
        insertarMascotasDeInicio(db);
        mascotas = db.obtenerTodasLasMascotas();
        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas() {
        ArrayList<Mascota> mascotasFavoritas = new ArrayList<>();
        mascotasFavoritas = obtenerDatos();
        Collections.sort(mascotasFavoritas);
        if (mascotasFavoritas.size() >= 6) { mascotasFavoritas.remove(6); }
        if (mascotasFavoritas.size() >= 5) { mascotasFavoritas.remove(5); }
        return mascotasFavoritas;
    }

    public void insertarMascotasDeInicio(BaseDatos db) {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        mascotas = db.obtenerTodasLasMascotas();

        if (mascotas.size() <= 0) {

            ContentValues contentValues = new ContentValues();

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Geiser");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Pastor Alemán");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.pastor_aleman);
            db.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Katuska");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Alaska Malamute");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.alaska_malamute);
            db.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Dakota");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Beagle");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.beagle);
            db.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Manchas");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Yorkshire Terrier");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.yorkshire);
            db.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Benji");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Cocker Spaniel");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.cocker);
            db.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Apollo");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Husky Siberiano");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.husky_siberiano);
            db.insertarMascota(contentValues);

            contentValues.put(ConstantesBD.TABLA_MASCOTA_NOMBRE, "Scooby");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_RAZA, "Labrador");
            contentValues.put(ConstantesBD.TABLA_MASCOTA_FOTO, R.drawable.labrador);
            db.insertarMascota(contentValues);
        }
    }

    public void insertarRatingMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(contexto);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBD.TABLA_RATINGS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBD.TABLA_RATINGS_NUMERO_RATINGS, RATING);
        db.insertarRatingMascota(contentValues);
    }

    public int obtenerRatingsMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(contexto);
        return db.obtenerRatingsMascota(mascota);
    }
}
