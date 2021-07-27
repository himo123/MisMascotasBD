package com.himo.mismascotasfragbd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.himo.mismascotasfragbd.email.SendMail;

    // El código implementado en esta clase para enviar el correo electrónico fue tomado del sitio:
    // https://www.simplifiedcoding.net/android-email-app-using-javamail-api-in-android-studio/
    // Las adecuaciones fueron realizadas por HECTOR IVAN MORALES OVANDO

    public class ContactoActivity extends AppCompatActivity implements View.OnClickListener {

        private EditText edtDestinatario;
        private EditText edtAsunto;
        private EditText edtMensaje;
        private Button btnSiguiente;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_contacto);

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

            edtDestinatario = (EditText) findViewById(R.id.edtDestinatario);
            edtAsunto = (EditText) findViewById(R.id.edtAsunto);
            edtMensaje = (EditText) findViewById(R.id.edtMensaje);
            btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
            btnSiguiente.setOnClickListener(this);
        }

        private void sendEmail() {
            //Getting content for email
            String destinatario = edtDestinatario.getText().toString().trim();
            String asunto = edtAsunto.getText().toString().trim();
            String mensaje = edtMensaje.getText().toString().trim();

            //Creating SendMail object
            SendMail sm = new SendMail(this, destinatario, asunto, mensaje);

            //Executing sendmail to send email
            sm.execute();
        }

        @Override
        public void onClick(View v) {
            sendEmail();
        }
    }