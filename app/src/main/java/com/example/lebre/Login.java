package com.example.lebre;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class Login extends AppCompatActivity {

    ArrayList<Usuario> usuariosList = new ArrayList();

    private Button login;
    private Button esqueceuSenha;
    private Button cadastro;
    private TextInputLayout email;
    private TextInputLayout senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login_button);

        esqueceuSenha = findViewById(R.id.esquecerSenha);
        esqueceuSenha.setPaintFlags(esqueceuSenha.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        esqueceuSenha.getPaint().setUnderlineText(true);

        cadastro = findViewById(R.id.newUsuario_button);
        cadastro.setPaintFlags(cadastro.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        cadastro.getPaint().setUnderlineText(true);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputLayout email = findViewById(R.id.email_input);
                TextInputLayout senha = findViewById(R.id.senha_input);

                String getEmail = email.getEditText().getText().toString();
                String getSenha = senha.getEditText().getText().toString();

                try {
                Gerenciamento_Arquivo.LerUsuarioNoSD(Login.this, usuariosList);
                Usuario usuarioLogin;
                usuarioLogin = Gerenciamento_Arquivo.VerificaUsuarioArrayList(usuariosList, getEmail, getSenha);
                validaLogin(usuarioLogin);
                }catch(Exception e){
                    Alerta(e.getMessage());
                }
            }
        });

        cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(Login.this, Signup.class);
            startActivity(intent);
            }
        });
    }

    public void Alerta(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private void validaLogin(Usuario usuarioLogin){
        if (usuarioLogin != null) {
            Alerta("Seja Bem-Vindo!");
            Bundle args = new Bundle();
            args.putSerializable("BundleUsuario", usuarioLogin);

            Intent intent = new Intent(Login.this, MainScreen.class);
            intent.putExtra("Usuario", args);
            startActivity(intent);
            finish();
        } else {
            email.setError("Email não encontado");
            senha.setError("Senha não encontrada.");
            Alerta("Usuário não encontrado, tente novamente ou cadastre-se.");
        }
    }
}
