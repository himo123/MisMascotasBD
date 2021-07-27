package com.himo.mismascotasfragbd.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Comparable, Parcelable {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    private int id;
    private String nombre;
    //private String tipo; //perro, gato, loro
    private String raza;
    //private int edad;
    //private String genero; //macho, hembra
    private int foto;
    private int rating;

    public Mascota(String nombre, String raza, int foto, int rating) {
        this.nombre = nombre;
        this.raza = raza;
        this.foto = foto;
        this.rating = rating;
    }

    protected Mascota(Parcel in) {
        nombre = in.readString();
        raza = in.readString();
        foto = in.readInt();
        rating = in.readInt();
    }

    public Mascota() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(raza);
        dest.writeInt(foto);
        dest.writeInt(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public int compareTo(Object o) {
        int comparaLikes = ((Mascota)o).getRating();   //este código lo copie de internet para ordenar las mascotas según su rating
        return comparaLikes - this.rating;
    }

}