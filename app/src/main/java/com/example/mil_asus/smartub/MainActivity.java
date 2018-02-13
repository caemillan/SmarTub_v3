package com.example.mil_asus.smartub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mil_asus.smartub.login_register.Initial_Session;
import com.example.mil_asus.smartub.login_register.Registrarse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonIniciarSesion = findViewById(R.id.button_IniciarSesionMA);
        final Button buttonRegistrarse = findViewById(R.id.button_RegistrarseMA);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentLaunchIniciarSesionActivity = new Intent(MainActivity.this, Initial_Session.class); //porque poner class
                startActivity(intentLaunchIniciarSesionActivity);
            }
        });

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intentLaunchRegistrarActivity = new Intent(MainActivity.this, Registrarse.class); //porque poner class
                startActivity(intentLaunchRegistrarActivity);
            }
        });

    }
}
