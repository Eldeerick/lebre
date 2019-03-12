package com.example.lebre;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class login extends AppCompatActivity {

    ArrayList<Usuario> usuariosList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login_button);
        Button newUsuario = findViewById(R.id.newUsuario_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.email_input);
                EditText senha = findViewById(R.id.senha_input);

                String getEmail = email.getText().toString();
                String getSenha = senha.getText().toString();

                try {
                Gerenciamento_Arquivo.LerUsuarioNoSD(getApplicationContext(), login.this, usuariosList);
                Usuario usuarioLogin;

                usuarioLogin = Gerenciamento_Arquivo.VerificaUsuarioArrayList(usuariosList, getEmail, getSenha);

                    if (usuarioLogin == null) {
                        Alerta(getApplicationContext(), " Não encontrado, tente novamente ou cadastre-se.");
                    } else {
                        Alerta(getApplicationContext(), "Seja Bem-Vindo!");
                        Intent i = new Intent(login.this, signup.class);
                        startActivity(i);
                    }
                }catch(Exception e){
                    Alerta(getApplicationContext(), e.getMessage());
                }
            }
        });

        newUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(login.this, signup.class);
            startActivity(intent);
            }
        });

    }

    public void Alerta(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
