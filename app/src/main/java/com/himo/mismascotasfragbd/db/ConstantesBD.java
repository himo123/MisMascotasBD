package com.himo.mismascotasfragbd.db;

public class ConstantesBD {

    //Generales
    public static final String DATABASE_NAME = "mismascotas";
    public static final int DATABASE_VERSION = 1;

    //Tabla Mascota
    public static final String TABLA_MASCOTA = "mascota";
    public static final String TABLA_MASCOTA_ID = "id";
    public static final String TABLA_MASCOTA_NOMBRE = "nombre";
    public static final String TABLA_MASCOTA_RAZA = "raza";
    public static final String TABLA_MASCOTA_FOTO = "foto";

    //Tabla Ratings
    public static final String TABLA_RATINGS = "ratings";
    public static final String TABLA_RATINGS_ID = "id";
    public static final String TABLA_RATINGS_ID_MASCOTA = "id_mascota";
    public static final String TABLA_RATINGS_NUMERO_RATINGS = "numero_ratings";

}
