package com.example.lebre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    private TextView tvNome;
    private TextView tvCPF;
    private TextView tvEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_emergencia);

        tvNome = findViewById(R.id.textViewNome);
        tvCPF = findViewById(R.id.textViewCPF);
        tvEstado = findViewById(R.id.textViewEstado);

        Bundle args = getIntent().getBundleExtra("Usuario");

        Usuario usuario = (Usuario) args.getSerializable("BundleUsuario");
        tvNome.setText("Olá, " + usuario.getNomeCompleto() + ".");
        tvCPF.setText("CPF: " + usuario.getCpf());
        tvEstado.setText("Estado: " + usuario.getEstado());
    }

    public void click(View v){
        Intent intent = new Intent(MainScreen.this, CadastrarEmergencia.class);
        startActivity(intent);
    }
}
