package com.example.lebre;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {

    ArrayList<Usuario> usuariosList = new ArrayList<>();

    Usuario novoUsuario = new Usuario();

    private TextInputLayout email;
    private TextInputLayout senha;
    private TextInputLayout confirmSenha;
    private TextInputLayout nomeCompleto;
    private TextInputLayout cpf;
    private TextInputLayout telefone;
    private TextInputLayout estado;
    private TextInputLayout cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        email = findViewById(R.id.novo_email_input);
        senha = findViewById(R.id.novo_senha_input);
        confirmSenha = findViewById(R.id.confirmar_senha_input);
        nomeCompleto = findViewById(R.id.nome_completo_input);
        cpf = findViewById(R.id.cpf_input);
        telefone = findViewById(R.id.phone_input);
        estado = findViewById(R.id.estado_input);
        cidade = findViewById(R.id.cidade_input);

    }

    public boolean validaEmail() {
        String email_content = email.getEditText().getText().toString().trim();
        Gerenciamento_Arquivo.LerUsuarioNoSD(Signup.this, usuariosList);
        Usuario verificaEmail = Gerenciamento_Arquivo.VerificaUsuarioArrayList(usuariosList, email_content);

        if (verificaEmail != null) {
            email.setError("O email já está cadastrado.");
            email.requestFocus();
            return false;
        } else if (email_content.isEmpty()) {
            email.setError("O campo não pode estar vazio.");
            email.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email_content).matches()) {
            email.setError("O email não é válido.");
            email.requestFocus();
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            email.clearFocus();
            novoUsuario.setEmail(email_content);
            return true;
        }
    }

    public boolean validaSenha() {
        String senha_content = senha.getEditText().getText().toString().trim();
        String confirm_senha_content = confirmSenha.getEditText().getText().toString().trim();

        if (senha_content.isEmpty()) {
            senha.setError("Você precisa definir uma senha.");
            confirmSenha.setError("As senhas precisam ser iguais.");
            senha.requestFocus();
            return false;
        } else if (senha_content.length() < 5) {
            senha.setError("A senha precisa ter no mínimo 6 caracteres.");
            senha.requestFocus();
            return false;
        } else if (!senha_content.equals(confirm_senha_content)) {
            senha.setError("As senhas precisam ser iguais.");
            senha.requestFocus();
            confirmSenha.setError("As senhas precisam ser iguais.");
            return false;
        } else {
            senha.setError(null);
            senha.setErrorEnabled(false);
            senha.clearFocus();
            confirmSenha.setError(null);
            confirmSenha.setErrorEnabled(false);
            confirmSenha.clearFocus();
            novoUsuario.setSenha(senha_content);
            return true;
        }

    }

    public boolean validaNomeCompleto() {
        String nomeCompleto_content = nomeCompleto.getEditText().getText().toString().trim();

        if (nomeCompleto_content.isEmpty()) {
            nomeCompleto.setError("O campo não pode estar vazio.");
            nomeCompleto.requestFocus();
            return false;
        } else {
            nomeCompleto.setError(null);
            nomeCompleto.setErrorEnabled(false);
            nomeCompleto.clearFocus();
            novoUsuario.setNomeCompleto(nomeCompleto_content);
            return true;
        }
    }

    public boolean validaCPF() {
        String cpf_content = cpf.getEditText().getText().toString().trim();

        if (cpf_content.isEmpty()) {
            cpf.setError("O campo não pode estar vazio.");
            cpf.requestFocus();
            return false;
        } else if (cpf_content.length() < 10) {
            cpf.setError("CPF inválido.");
            cpf.requestFocus();
            return false;
        } else {
            cpf.setError(null);
            cpf.setErrorEnabled(false);
            cpf.clearFocus();
            novoUsuario.setCpf(cpf_content);
            return true;
        }
    }

    public boolean validaTelefone() {
        String telefone_content = telefone.getEditText().getText().toString().trim();

        if (telefone_content.isEmpty()) {
            telefone.setError("O campo não pode estar vazio.");
            telefone.requestFocus();
            return false;
        } else {
            telefone.setError(null);
            telefone.setErrorEnabled(false);
            telefone.clearFocus();
            novoUsuario.setTelefone(telefone_content);
            return true;
        }
    }

    public boolean validaEstado() {
        String estado_content = estado.getEditText().getText().toString().trim();

        if (estado_content.isEmpty()) {
            estado.setError("O campo não pode estar vazio.");
            telefone.requestFocus();
            return false;
        } else {
            estado.setError(null);
            estado.setErrorEnabled(false);
            estado.clearFocus();
            novoUsuario.setEstado(estado_content);
            return true;
        }
    }

    public boolean validaCidade() {
        String cidade_content = cidade.getEditText().getText().toString().trim();

        if (cidade_content.isEmpty()) {
            cidade.setError("O campo não pode estar vazio.");
            cidade.requestFocus();
            return false;
        } else {
            cidade.setError(null);
            cidade.setErrorEnabled(false);
            cidade.clearFocus();
            novoUsuario.setCidade(cidade_content);
            return true;
        }
    }

    public void Finalizar(View v) {
        if (!validaEmail() | !validaSenha() | !validaNomeCompleto() | !validaCPF() | !validaTelefone() | !validaEstado() | !validaCidade())
            return;

        Gerenciamento_Arquivo.gravarUsuarioNoSD(Signup.this, novoUsuario.getAllInfo());

        Bundle args = new Bundle();
        args.putSerializable("BundleUsuario", novoUsuario);

        Intent intent = new Intent(Signup.this, Login.class);
        //intent.putExtra("Usuario", args);
        startActivity(intent);
    }


}
