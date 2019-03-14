package com.example.lebre;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class signup extends AppCompatActivity {

    ArrayList<Usuario> usuariosList = new ArrayList<>();

    Usuario novoUsuario = new Usuario();

    private TextInputLayout email;
    private TextInputLayout senha;
    private TextInputLayout confirmSenha ;
    private TextInputLayout nomeCompleto ;
    private TextInputLayout cpf ;
    private TextInputLayout telefone;
    private TextInputLayout estado ;
    private TextInputLayout cidade ;

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

    public boolean validaEmail(){
        String email_content = email.getEditText().getText().toString().trim();
        Gerenciamento_Arquivo.LerUsuarioNoSD(signup.this, usuariosList);
        Usuario verificaEmail = Gerenciamento_Arquivo.VerificaUsuarioArrayList(usuariosList, email_content);

        if(verificaEmail != null){
            email.setError("O email já está cadastrado.");
            return false;
        }else if(email_content.isEmpty()){
            email.setError("O campo não pode estar vazio.");
            return false;
        }else{
            email.setError(null);
            novoUsuario.setEmail(email_content);
            return true;
        }
    }

    public boolean validaSenha(){
        String senha_content = senha.getEditText().getText().toString().trim();
        String confirm_senha_content = confirmSenha.getEditText().getText().toString().trim();

        if(senha_content.isEmpty()) {
            senha.setError("Você precisa definir uma senha.");
            return false;
        }else if(senha_content.length() < 5){
            senha.setError("A senha precisa ter no mínimo 6 caracteres.");
            return false;
        }else if(!senha_content.equals(confirm_senha_content)){
            senha.setError("As senhas precisam ser iguais.");
            confirmSenha.setError("As senhas precisam ser iguais.");
            return false;
        }else{
            senha.setError(null);
            confirmSenha.setError(null);
            novoUsuario.setSenha(senha_content);
            return true;
        }

    }

    public boolean validaNomeCompleto(){
        String nomeCompleto_content = nomeCompleto.getEditText().getText().toString().trim();

        if(nomeCompleto_content.isEmpty()){
            nomeCompleto.setError("O campo não pode estar vazio.");
            return false;
        }else{
            nomeCompleto.setError(null);
            novoUsuario.setNomeCompleto(nomeCompleto_content);
            return true;
        }
    }

    public boolean validaCPF(){
        String cpf_content = cpf.getEditText().getText().toString().trim();

        if(cpf_content.isEmpty()){
            cpf.setError("O campo não pode estar vazio.");
            return false;
        }else if(cpf_content.length() < 10) {
            cpf.setError("CPF inválido.");
            return false;
        }else{
            cpf.setError(null);
            novoUsuario.setCpf(cpf_content);
            return true;
        }
    }

    public boolean validaTelefone(){
        String telefone_content = telefone.getEditText().getText().toString().trim();

        if(telefone_content.isEmpty()){
            telefone.setError("O campo não pode estar vazio.");
            return false;
        }else{
            telefone.setError(null);
            novoUsuario.setTelefone(telefone_content);
            return true;
        }
    }

    public boolean validaEstado(){
        String estado_content = estado.getEditText().getText().toString().trim();

        if(estado_content.isEmpty()){
            estado.setError("O campo não pode estar vazio.");
            return false;
        }else{
            estado.setError(null);
            novoUsuario.setEstado(estado_content);
            return true;
        }
    }

    public boolean validaCidade(){
        String cidade_content = cidade.getEditText().getText().toString().trim();

        if(cidade_content.isEmpty()){
            estado.setError("O campo não pode estar vazio.");
            return false;
        }else{
            estado.setError(null);
            novoUsuario.setCidade(cidade_content);
            return true;
        }
    }

    public void Finalizar(View v){
        if(!validaEmail() | !validaSenha() | !validaNomeCompleto() | !validaCPF() | !validaTelefone() | !validaEstado() | !validaCidade())
            return;

        String content = novoUsuario.getAllInfo();

        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
