package com.example.lebre;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gerenciamento_Arquivo {
    private static final String usuariosArq = "usersInfo.txt";
    private static final String diretorio = "lebreFiles";
    private static final String ocorrenciasArq = "ocorrencias.txt";

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static void gravarUsuarioNoSD(Activity activity, String conteudo) {
        verificarPermissoes(activity);
        try {
            File root = new File(Environment.getExternalStorageDirectory(), diretorio);
            //Se o local não existir, cria uma nova pasta com arquivo;
            if (!root.exists()) {
                root.mkdirs();
                root.createNewFile();
            }

            File file = new File(root, usuariosArq);
            FileWriter writer = new FileWriter(file, true);
            writer.append(conteudo);
            writer.flush();
            writer.close();
        } catch (IOException e) {

        }
    }

    public static void gravarOcorrenciaSD(String conteudo){
        try {
            File root = new File(Environment.getExternalStorageDirectory(), diretorio);
            //Se o local não existir, cria uma nova pasta com arquivo;
            if (!root.exists()) {
                root.mkdirs();
                root.createNewFile();
            }

            File file = new File(root, ocorrenciasArq);
            FileWriter writer = new FileWriter(file, true);
            writer.append(conteudo);
            writer.flush();
            writer.close();
        } catch (IOException e) {

        }
    }

    public static ArrayList lerOcorrenciaSD(ArrayList<Ocorrencia> ocorrencias){
        String TipoOcorrencia, cpf, status;
        try{
            File root = new File(Environment.getExternalStorageDirectory(), diretorio);

            File file = new File(root, ocorrenciasArq);
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String linha;

            linha = br.readLine();

            while(linha != null) {
                TipoOcorrencia = linha.split(";")[0];
                cpf = linha.split(";")[1];
                status = linha.split(";")[2];

                Ocorrencia getOcorrenciasfromSD = new Ocorrencia(TipoOcorrencia, cpf, status);
                ocorrencias.add(getOcorrenciasfromSD);
                linha = br.readLine();
            }
            reader.close();
            br.close();
        }catch(IOException e){

        }catch (Exception e){

        }
        return ocorrencias;
    }


    public static ArrayList LerUsuarioNoSD(Activity activity, ArrayList<Usuario> usuariosList){
        String email;
        String senha;
        String nomeCompleto;
        String cpf;
        String telefone;
        String estado;
        String cidade;

        verificarPermissoes(activity);
        try{
            File root = new File(Environment.getExternalStorageDirectory(), diretorio);

            File file = new File(root, usuariosArq);
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String linha;

            linha = br.readLine();

            while(linha != null) {
                email = linha.split(";")[0];
                senha = linha.split(";")[1];
                nomeCompleto = linha.split(";")[2];
                cpf = linha.split(";")[3];
                telefone = linha.split(";")[4];
                estado = linha.split(";")[5];
                cidade = linha.split(";")[6];

                Usuario user = new Usuario(email, senha, nomeCompleto, cpf, telefone, estado, cidade);
                usuariosList.add(user);
                linha = br.readLine();
            }
            reader.close();
            br.close();
        }catch(IOException e){

        }catch (Exception e){

        }
        return usuariosList;
    }

    public static Usuario VerificaUsuarioArrayList(ArrayList<Usuario> usuariosList, String email){
        for (Usuario usuario: usuariosList) {
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    public static Usuario VerificaUsuarioArrayList(ArrayList<Usuario> usuariosList, String email, String senha){
        for (Usuario usuario: usuariosList) {
            if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)){
                return usuario;
            }
        }
        return null;
    }

    public static ArrayList VerificaOcorrenciaArrayList(ArrayList<Ocorrencia> TodasasOcorrencias, ArrayList<Ocorrencia> ocorrenciasAMostrar, Usuario usuario){
        for (Ocorrencia ocorrencia: TodasasOcorrencias) {
            if(ocorrencia.getCpfUser().equals(usuario.getCpf())){
                ocorrenciasAMostrar.add(ocorrencia);
            }
        }
        return ocorrenciasAMostrar;
    }


    public static void verificarPermissoes(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }
    }
}
