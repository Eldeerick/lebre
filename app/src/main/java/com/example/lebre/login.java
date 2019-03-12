package com.example.lebre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final String file = "C:\\Users\\Usuario\\AndroidStudioProjects\\Lebre\\app\\src\\main\\res\\files\\usuarios.txt";


        Button login = findViewById(R.id.login_button);
        Button newUsuario = findViewById(R.id.newUsuario_button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.email_input);
                EditText senha = findViewById(R.id.senha_input);

                String getEmail = email.getText().toString();
                String getSenha = senha.getText().toString();

                Usuario usuario = new Usuario(getEmail, getSenha);



                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                    String loginContent = "\n" + usuario.getEmail() + ";" + usuario.getSenha() + ";";
                    bw.append(loginContent);
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(usuario.getEmail().equals("erick")) {
                    Intent intent = new Intent(login.this, signup.class);
                    startActivity(intent);
                }
            }
        });

        //Vai para a tela de cadastro de usuario
        newUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(login.this, signup.class);
            startActivity(intent);
            }
        });

    }
}
