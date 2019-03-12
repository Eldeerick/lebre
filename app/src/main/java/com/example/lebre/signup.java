package com.example.lebre;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Alerta(getApplicationContext(), "Digite uma senha com no mínimo 8 caracteres.");

        Button cadastro = findViewById(R.id.cadastrar_button);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.novo_email_input);
                EditText senha = findViewById(R.id.nova_senha_input);
                EditText confirmSenha = findViewById(R.id.confirmar_senha_input);

                String email_content = email.getText().toString();
                String senha_content = senha.getText().toString();
                String confirmar_senha_content = confirmSenha.getText().toString();

                if(senha_content.length() < 8 || senha_content.isEmpty())
                    Alerta(getApplicationContext(), "Digite uma senha com no mínimo 8 caracteres.");
                else {
                    if (senha_content.equals(confirmar_senha_content)) {
                        Usuario novoUsuario = new Usuario(email_content, senha_content);

                        Bundle args = new Bundle();
                        args.putSerializable("novoUsuario", novoUsuario);

                        Intent intent = new Intent(signup.this, signup_personal_info.class);
                        intent.putExtra("Usuario", args);

                        startActivity(intent);
                    }
                }
            }
        });
    }

    public void Alerta(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
