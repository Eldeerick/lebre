package com.example.lebre;
import android.content.Context;
import android.widget.Toast;

import java.io.Serializable;

public class Usuario implements  Serializable{
    private String email = "";
    private String senha = "";
    private String nomeCompleto = "";
    private String cpf = "";
    private String estado = "";
    private String cidade = "";
    private String telefone = "";

    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public void setUsuarioInfo(String nomeCompleto, String cpf, String telefone, String estado, String cidade){
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getAllInfo(){
        return "\n" + this.getEmail() + ";"
                + this.getSenha() + ";" + this.getNomeCompleto() + ";"
                + this.getCpf() + ";" + this.getTelefone() + ";"
                + this.getEstado() + ";" +this.getCidade() + ";";
    }



    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }
}
