package com.example.mil_asus.smartub.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mil_asus.smartub.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

/**
 * Created by Mil_ASUS on 22/1/2018.
 */

public class Registrarse extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextIngresar_email_reg;
    private EditText editTextIngresar_Contraseña_reg;

    FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        editTextIngresar_email_reg = (EditText) findViewById(R.id.editTextIngresar_email_reg);
        editTextIngresar_Contraseña_reg = (EditText) findViewById(R.id.editTextIngresar_Contraseña_reg);
        findViewById(R.id.button_Registrarse).setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };

       /* mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user !=null ) {
                    Log.i("SESION", "Sesion Iniciada: "+user.getEmail());

                }else {
                    Log.i("SESION", "Sesion cerrada");
                }
            }
        };*/
    }

    private void registrar (String cuenta, String contraseña) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(cuenta,contraseña);
    }

    @Override
    public void onClick(View view) {
        String cuenta = editTextIngresar_email_reg.getText().toString();
        String contraseña = editTextIngresar_Contraseña_reg.getText().toString();
        registrar(cuenta,contraseña);
        Intent intenLogin = new Intent(this, Initial_Session.class);
        startActivity(intenLogin);
        Toast.makeText(this, "Registado correctamente", Toast.LENGTH_SHORT).show();
    }
}
