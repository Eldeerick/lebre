package com.example.lebre;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    public static final int REQUEST_RESULT_CODE = 10;
    private TextView tvNome;
    private TextView tvEmail;
    private TextView tvCPF;
    private TextView tvEstado;
    private ListView ocorrencias_cadastradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        tvNome = findViewById(R.id.textViewNome);
        tvEmail = findViewById(R.id.textViewEmail);
        tvCPF = findViewById(R.id.textViewCPF);
        tvEstado = findViewById(R.id.textViewEstado);
        ocorrencias_cadastradas = findViewById(R.id.listview);

        Bundle args = getIntent().getBundleExtra("Usuario");

        Usuario usuario = (Usuario) args.getSerializable("BundleUsuario");
        tvNome.setText("Olá, " + usuario.getNomeCompleto() + ".");
        tvEmail.setText("Email: " + usuario.getEmail());
        tvCPF.setText("CPF: " + usuario.getCpf());
        tvEstado.setText("Estado: " + usuario.getEstado());

    }

    public void click(View v){
        Intent intent = new Intent(MainScreen.this, CadastrarEmergencia.class);
        startActivityForResult(intent, REQUEST_RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        ocorrencias_cadastradas = findViewById(R.id.listview);
        switch(requestCode){
            case REQUEST_RESULT_CODE:
                if(resultCode == Activity.RESULT_OK){
                    String ocorrencia = data.getStringExtra("IntentOcorrencia");

                    ArrayList<String> ocorrencias = new ArrayList<>();
                    ocorrencias.add(ocorrencia);
                    ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ocorrencias);

                    ocorrencias_cadastradas.setAdapter(arrayAdapter);
                }
        }
    }
}
