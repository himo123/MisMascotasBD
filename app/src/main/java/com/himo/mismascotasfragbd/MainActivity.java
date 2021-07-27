package com.himo.mismascotasfragbd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.himo.mismascotasfragbd.adapter.PageAdapter;
import com.himo.mismascotasfragbd.vista.MascotasFavoritasActivity;
import com.himo.mismascotasfragbd.vista.PerfilFragment;
import com.himo.mismascotasfragbd.vista.RecyclerViewFragment;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    private TabLayout miTabLayout;
    private ViewPager miViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miTabLayout = findViewById(R.id.miTabLayout);
        miViewPager = findViewById(R.id.miViewPager);
        Toolbar miToolBar = findViewById(R.id.miToolBar);
        if (miToolBar != null) {
            setSupportActionBar(miToolBar);
        }

        inicializarViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intento;
        int itemId = item.getItemId();
        if (itemId == R.id.mContacto) {
            intento = new Intent(this, ContactoActivity.class);
            startActivity(intento);
        } else if (itemId == R.id.mAcercaDe) {
            intento = new Intent(this, AcercaDeActivity.class);
            startActivity(intento);
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializarViewPager() {
        miViewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        miTabLayout.setupWithViewPager(miViewPager);
        Objects.requireNonNull(miTabLayout.getTabAt(0)).setIcon(R.drawable.ic_casa_perros);
        Objects.requireNonNull(miTabLayout.getTabAt(1)).setIcon(R.drawable.ic_perros);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void mostrarMascotasFavoritas(View v) {
        Intent intento = new Intent(this, MascotasFavoritasActivity.class);
//        intento.putParcelableArrayListExtra("mascotas", mascotasGlobal); //La clase Mascota implements Parcelable
        this.startActivity(intento);
    }

}