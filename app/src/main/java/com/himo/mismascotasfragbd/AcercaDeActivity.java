package com.himo.mismascotasfragbd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaDeActivity extends AppCompatActivity {

    //CÓDIGO GENERADO POR HECTOR IVAN MORALES OVANDO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miToolBar = (Toolbar) findViewById(R.id.miToolBar);
        if (miToolBar != null) {
            setSupportActionBar(miToolBar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //muestra la flecha de regreso (se declara el parent en AndroidManifest)

        Button button_favoritos = (Button) findViewById(R.id.btn_favoritos);
        button_favoritos.setVisibility(View.INVISIBLE);

        assert miToolBar != null;
        miToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }
}