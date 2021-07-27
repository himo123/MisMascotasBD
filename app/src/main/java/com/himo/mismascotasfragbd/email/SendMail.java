package com.himo.mismascotasfragbd.email;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

    // El código de esta clase fue tomado del sitio:
    // https://www.simplifiedcoding.net/android-email-app-using-javamail-api-in-android-studio/
    // Esta clase hereda AsyncTask porque realiza operaciones de networking
    // Las adecuaciones y traducciones fueron realizadas por HECTOR IVAN MORALES OVANDO

    public class SendMail extends AsyncTask<Void,Void,Void> {

        private Context contexto;

        private final String destinatario;
        private final String asunto;
        private final String mensaje;

        //Ventana para mostrar el avance mientras se envía el mensaje
        private ProgressDialog ventanaDeProgreso;

         public SendMail(Context contexto, String destinatario, String asunto, String mensaje){
            //Se inicializan las variables
            this.contexto = contexto;
            this.destinatario = destinatario;
            this.asunto = asunto;
            this.mensaje = mensaje;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Muestra la ventana de progreso mientras se envía el mensaje
            ventanaDeProgreso = ProgressDialog.show(contexto,"Enviando mensaje","Espere un momento...",false,false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Una vez ejecutada la tarea, se descarta la ventana de progreso
            ventanaDeProgreso.dismiss();
            //Y posteriormente se muestra un mensaje de confirmación
            Toast.makeText(contexto,"Mensaje enviado exitosamente",Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Se crean las propiedades para el envío
            Properties propiedades = new Properties();

            //Configurando propiedades exclusivas para Gmail
            propiedades.put("mail.smtp.host", "smtp.gmail.com");
            propiedades.put("mail.smtp.socketFactory.port", "465");
            propiedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            propiedades.put("mail.smtp.auth", "true");
            propiedades.put("mail.smtp.port", "465");

            //Creando una nueva sesión
            //Verificando el password...
            Session sesion = Session.getDefaultInstance(propiedades,
                    new javax.mail.Authenticator() {
                        //Authenticating the password
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(Config.EMAIL, Config.PASSWORD);
                        }
                    });

            try {
                //Creando el objeto MimeMessage
                MimeMessage mm = new MimeMessage(sesion);

                //Configurando dirección del remitente
                mm.setFrom(new InternetAddress(Config.EMAIL));
                //Agregando el destinatario
                mm.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
                //Agregando el asunto
                mm.setSubject(asunto);
                //Agregando el mensaje
                mm.setText(mensaje);

                //Enviando el correo
                Transport.send(mm);

            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return null;
        }

    }