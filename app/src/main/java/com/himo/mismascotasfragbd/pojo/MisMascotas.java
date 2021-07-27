package com.himo.mismascotasfragbd.pojo;

import com.himo.mismascotasfragbd.R;
import java.util.ArrayList;

public class MisMascotas {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    public ArrayList<Mascota> misMascotas() {
        ArrayList<Mascota> mascotasFavoritas;
        mascotasFavoritas = new ArrayList<>();   //Inicializa el ArrayList usando la misma información de MainActivity
        mascotasFavoritas.add(new Mascota("Katuska", "Alaska Malamute",   R.drawable.alaska_malamute, 0));
        mascotasFavoritas.add(new Mascota("Dakota",  "Beagle",            R.drawable.beagle,          0));
        mascotasFavoritas.add(new Mascota("Benji",   "Cocker Spaniel",    R.drawable.cocker,          0));
        mascotasFavoritas.add(new Mascota("Apollo",  "Husky Siberiano",   R.drawable.husky_siberiano, 0));
        mascotasFavoritas.add(new Mascota("Scoop",   "Labrador",          R.drawable.labrador,        0));
        mascotasFavoritas.add(new Mascota("Geiser",  "Pastor Alemán",     R.drawable.pastor_aleman,   0));
        mascotasFavoritas.add(new Mascota("Manchas", "Yorkshire Terrier", R.drawable.yorkshire,       0));
        return mascotasFavoritas;
    }

    public ArrayList<Mascota> misMascotas(int maxRatingAleatorio) {
        ArrayList<Mascota> mascotasRating;
        mascotasRating = misMascotas();

        //Asignar ratings aleatorios a las mascotas
        mascotasRating.get(0).setRating((int) (Math.random() * maxRatingAleatorio + 1));
        mascotasRating.get(1).setRating((int) (Math.random() * maxRatingAleatorio + 1));
        mascotasRating.get(2).setRating((int) (Math.random() * maxRatingAleatorio + 1));
        mascotasRating.get(3).setRating((int) (Math.random() * maxRatingAleatorio + 1));
        mascotasRating.get(4).setRating((int) (Math.random() * maxRatingAleatorio + 1));
        mascotasRating.get(5).setRating((int) (Math.random() * maxRatingAleatorio + 1));
        mascotasRating.get(6).setRating((int) (Math.random() * maxRatingAleatorio + 1));

        return mascotasRating;
    }

    public ArrayList<Mascota> soloUnaMascota(int maxRatingAleatorio) {
        ArrayList<Mascota> listaDeMascotas = misMascotas(maxRatingAleatorio);
        //Genero una lista nueva para almacenar las instancias de la misma mascota
        ArrayList<Mascota> unaMascota = new ArrayList<>();

        //Este indiceAleatorio establece un índice fijo para que siempre seleccione la misma mascota
        //en la listaDeMascotas y se asigne a la lista nuevo
        int indiceAleatorio = (int) (Math.random() * listaDeMascotas.size());

        for (int i = 0; i < 9; i++) {
            //en cada bucle instancio el método para que al crearse le asigne nuevos ratings aleatorios
            //si no, siempre mostraría el mismo rating para cada instancia de mascota
            listaDeMascotas = misMascotas(maxRatingAleatorio);
            unaMascota.add(listaDeMascotas.get(indiceAleatorio));
        }

        return unaMascota;
    }
}
