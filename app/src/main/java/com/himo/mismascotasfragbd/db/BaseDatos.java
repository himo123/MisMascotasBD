package com.himo.mismascotasfragbd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.himo.mismascotasfragbd.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper{

    private Context contexto;

    public BaseDatos(@Nullable Context contexto) {
        super(contexto, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sentenciaCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLA_MASCOTA + "(" +
                ConstantesBD.TABLA_MASCOTA_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLA_MASCOTA_NOMBRE   + " TEXT, " +
                ConstantesBD.TABLA_MASCOTA_RAZA     + " RAZA, " +
                ConstantesBD.TABLA_MASCOTA_FOTO     + " INTEGER" +
                ")";

        String sentenciaCrearTablaRatings = "CREATE TABLE " + ConstantesBD.TABLA_RATINGS + "(" +
                ConstantesBD.TABLA_RATINGS_ID               + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLA_RATINGS_ID_MASCOTA       + " TEXT, " +
                ConstantesBD.TABLA_RATINGS_NUMERO_RATINGS   + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBD.TABLA_RATINGS_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBD.TABLA_MASCOTA + "(" + ConstantesBD.TABLA_MASCOTA_ID + ")" +
                ")";

        db.execSQL(sentenciaCrearTablaMascota);
        db.execSQL(sentenciaCrearTablaRatings);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLA_RATINGS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String sentencia = "SELECT * FROM " + ConstantesBD.TABLA_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(sentencia, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRaza(registros.getString(2));
            mascotaActual.setFoto(registros.getInt(3));

            String sentenciaRatings = "SELECT COUNT(" + ConstantesBD.TABLA_RATINGS_NUMERO_RATINGS + ") AS LIKES " +
                    " FROM " + ConstantesBD.TABLA_RATINGS +
                    " WHERE " + ConstantesBD.TABLA_RATINGS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosRatings = db.rawQuery(sentenciaRatings, null);
            if (registrosRatings.moveToNext()) {
                mascotaActual.setRating(registrosRatings.getInt(0));
            } else {
                mascotaActual.setRating(0);
            }
            //mascotaActual.setRating(obtenerRatingsMascota(mascotaActual));
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLA_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarRatingMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLA_RATINGS, null, contentValues);
        db.close();
    }

    public int obtenerRatingsMascota(Mascota mascota) {
        int ratings = 0;

        String sentencia = "SELECT COUNT(" + ConstantesBD.TABLA_RATINGS_NUMERO_RATINGS + ")" +
                " FROM " + ConstantesBD.TABLA_RATINGS +
                " WHERE " + ConstantesBD.TABLA_RATINGS_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(sentencia, null);

        if (registros.moveToNext()) {
            ratings = registros.getInt(0);
        }

        db.close();
        return ratings;
    }

}
