package com.example.lebre;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class signup_personal_info extends AppCompatActivity {

    ArrayList<Usuario> usuariosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_personal_info);

        /*Button finalizar = findViewById(R.id.finalizar_button);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText email = findViewById(R.id.novo_email_input);
                EditText senha = findViewById(R.id.nova_senha_input);
                EditText confirmSenha = findViewById(R.id.confirmar_senha_input);

                String email_content = email.getText().toString().trim();
                String senha_content = senha.getText().toString().trim();
                String confirmar_senha_content = confirmSenha.getText().toString().trim();

                Gerenciamento_Arquivo.LerUsuarioNoSD(getApplicationContext(), signup_personal_info.this, usuariosList);

                Usuario verificaEmail = Gerenciamento_Arquivo.VerificaUsuarioArrayList(usuariosList, email_content);

                if (verificaEmail == null) {
                    if(email_content.length() != 0) {
                        if (senha_content.length() > 5) {
                            if (senha_content.equals(confirmar_senha_content)) {
                                Usuario novoUsuario = new Usuario(email_content, senha_content);
                                trataInfoCadastro(novoUsuario);
                            } else {
                                senha.setError("Verifique a senha.");
                                confirmSenha.setError("Verifique a senha.");
                            }
                        } else {
                            senha.setError("Digite uma senha com no mínimo 6 caracteres.");
                        }
                    }else{
                        email.setError("Este campo não pode ficar vazio.");
                        email.requestFocus();
                        email.requestFocusFromTouch();
                    }
                }else{
                    email.setError("O email já está cadastrado.");
                    email.requestFocusFromTouch();
                }
            }
        });
    }

    private void trataInfoCadastro(Usuario novoUsuario){
        EditText nomeCompleto = findViewById(R.id.nome_completo_input);
        EditText cpf = findViewById(R.id.cpf_input);
        EditText telefone = findViewById(R.id.phone_input);
        EditText estado = findViewById(R.id.estado_input);
        EditText cidade = findViewById(R.id.cidade_input);

        String nomeCompleto_content = nomeCompleto.getText().toString().trim();
        String cpf_content = cpf.getText().toString().trim(); //11
        String telefone_content = telefone.getText().toString().trim();
        String estado_content = estado.getText().toString().trim();
        String cidade_content = cidade.getText().toString().trim();

        if(nomeCompleto_content.length() == 0)
            Alerta(getApplicationContext(), "O campo Nome Completo não pode estar vazio.");
        else if(cpf_content.length() < 10)
            Alerta(getApplicationContext(), "O campo CPF é inválido.");
        else if(telefone_content.length() == 0)
            Alerta(getApplicationContext(), "O campo Telefone não pode estar vazio.");
        else if(estado_content.length() == 0)
            Alerta(getApplicationContext(), "O campo Estado não pode estar vazio.");
        else if(cidade_content.length() == 0)
            Alerta(getApplicationContext(), "O campo Cidade não pode estar vazio.");
        else{
            novoUsuario.setUsuarioInfo(nomeCompleto_content,cpf_content,telefone_content, estado_content, cidade_content);

            Gerenciamento_Arquivo.gravarUsuarioNoSD(getApplicationContext(), signup_personal_info.this, novoUsuario.getAllInfo());
            Intent intent = new Intent(signup_personal_info.this, login.class);
            startActivity(intent);
        }*/
    }

    public void Alerta(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

}
