package com.example.lebre;

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

    public Usuario(){

    }

    public Usuario(String email, String senha, String nomeCompleto, String cpf, String telefone, String estado, String cidade){
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
    }

    public void setUsuarioInfo(String nomeCompleto, String cpf, String telefone, String estado, String cidade){
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.telefone = telefone;
        this.estado = estado;
        this.cidade = cidade;
    }

    public String getAllInfo(){
        return  this.getEmail() + ";"
                + this.getSenha() + ";" + this.getNomeCompleto() + ";"
                + this.getCpf() + ";" + this.getTelefone() + ";"
                + this.getEstado() + ";" +this.getCidade() + ";" +"\n";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
