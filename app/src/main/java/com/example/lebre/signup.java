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

public class signup extends AppCompatActivity {

    ArrayList<Usuario> usuariosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        /*Button cadastro = findViewById(R.id.cadastrar_button);

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.novo_email_input);
                EditText senha = findViewById(R.id.nova_senha_input);
                EditText confirmSenha = findViewById(R.id.confirmar_senha_input);

                String email_content = email.getText().toString();
                String senha_content = senha.getText().toString();
                String confirmar_senha_content = confirmSenha.getText().toString();

                Gerenciamento_Arquivo.LerUsuarioNoSD(getApplicationContext(), signup.this, usuariosList);

                Usuario verificaEmail = Gerenciamento_Arquivo.VerificaUsuarioArrayList(usuariosList, email_content);

                if (verificaEmail == null) {
                    if (senha_content.length() > 5) {
                        if (senha_content.equals(confirmar_senha_content)) {
                            Usuario novoUsuario = new Usuario(email_content, senha_content);

                            Bundle args = new Bundle();
                            args.putSerializable("novoUsuario", novoUsuario);

                            Intent intent = new Intent(signup.this, signup_personal_info.class);
                            intent.putExtra("Usuario", args);

                            startActivity(intent);
                        } else {
                            Alerta(getApplicationContext(), "Verifique se as senhas são iguais.");
                        }
                    } else {
                        Alerta(getApplicationContext(), "Digite uma senha com no mínimo 6 caracteres.");
                    }
                }else{
                    Alerta(getApplicationContext(), "O email já está cadastrado.");
                }
            }
        });*/
    }

    public void Alerta(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
