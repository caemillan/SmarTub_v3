package com.example.mil_asus.smartub.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mil_asus.smartub.InformationActivity;
import com.example.mil_asus.smartub.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Initial_Session extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextIngresar_email_loginactivity;
    private EditText editTextIngresar_Contraseña_loginactivity;

    private static final String TAG = "EmailPassword";

    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);
        editTextIngresar_email_loginactivity = findViewById(R.id.editTextIngresar_email_loginactivity);
        editTextIngresar_Contraseña_loginactivity = findViewById(R.id.editTextIngresar_Contraseña_loginactivity);
        final Button button_IniciarSesionAIS = findViewById(R.id.button_IniciarSesionAIS);
        button_IniciarSesionAIS.setOnClickListener(this);



        /*button_IniciarSesionAIS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentLaunchActivityInformation = new Intent(Initial_Session.this, InformationActivity.class);

                //if ()
                startActivity(intentLaunchActivityInformation);
            }
        });*/

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.i("SESION", "Sesion Iniciada: " + user.getEmail());

                } else {
                    Log.i("SESION", "Sesion cerrada");
                }
            }
        };
    }


    private void iniciarSesion (String cuenta, String contraseña){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(cuenta,contraseña).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                if (!task.isSuccessful()) {
                    Log.w(TAG, "signInWithEmail:failed", task.getException());
                    Toast.makeText(Initial_Session.this,"Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        String cuentaIS = editTextIngresar_email_loginactivity.getText().toString();
        String contraseñaIS = editTextIngresar_Contraseña_loginactivity.getText().toString();
        iniciarSesion(cuentaIS, contraseñaIS);
        Intent intentGOInformation = new Intent(this,InformationActivity.class);
        startActivity(intentGOInformation);
        Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show();

        /*Snackbar snackbar = Snackbar
                .make(v , "Bienvenido", Snackbar.LENGTH_LONG);

        snackbar.show();*/
    }
}
