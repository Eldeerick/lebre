package com.example.lebre;

import java.io.Serializable;

public class Ocorrencia implements Serializable {
    private String tipo;
    private String cpfUser;
    private String status;

    public Ocorrencia(String tipo, String cpfUser, String status) {
        this.tipo = tipo;
        this.cpfUser = cpfUser;
        this.status = status;
    }

    public String getAllInfo(){
        return this.getTipo() + ";" + this.getCpfUser() + ";" + this. getStatus() + ";" + "\n";
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "\nStatus: " + status;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCpfUser() {
        return cpfUser;
    }

    public String getStatus() {
        return status;
    }
}
