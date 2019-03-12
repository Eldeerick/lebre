package com.example.lebre;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class signup_personal_info extends AppCompatActivity {
    private File diretorio;
    private String nomeDiretorio = "lebre";
    private String diretorioApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_personal_info);

        Button finalizar = findViewById(R.id.finalizar_button);
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle args = getIntent().getBundleExtra("Usuario");

                EditText cpf = findViewById(R.id.cpf_input);
                EditText nomeCompleto = findViewById(R.id.nome_completo_input);
                EditText telefone = findViewById(R.id.phone_input);
                EditText estado = findViewById(R.id.estado_input);
                EditText cidade = findViewById(R.id.cidade_input);

                String cpf_content = cpf.getText().toString();
                String nomeCompleto_content = nomeCompleto.getText().toString();
                String telefone_content = telefone.getText().toString();
                String estado_content = estado.getText().toString();
                String cidade_content = cidade.getText().toString();

                if (args != null) {
                    Usuario usuario = (Usuario) args.getSerializable("novoUsuario");

                    usuario.setUsuarioInfo(cpf_content, nomeCompleto_content, telefone_content, estado_content, cidade_content);

                    /*diretorioApp = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";

                    diretorio = new File(diretorioApp);
                    diretorio.mkdirs();

                    File fileExt = new File(diretorioApp, "Usuarios.txt");
                    fileExt.getParentFile().mkdirs();

                    try {
                        FileOutputStream fosExt = new FileOutputStream(fileExt);
                        fosExt.write(usuario.getAllInfo().getBytes());
                        fosExt.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/

                }
            }
        });


    }
}
