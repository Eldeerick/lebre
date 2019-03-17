package com.example.lebre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainScreen extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_emergencia);

        tv = findViewById(R.id.info);

        Bundle args = getIntent().getBundleExtra("Usuario");

        Usuario usuario = (Usuario) args.getSerializable("BundleUsuario");

        if(args != null) {
            tv.setText(usuario.getAllInfo());
        }
    }

    public void click(View v){
        //Intent intent = new Intent(MainScreen.this, DadosEmergencia.class);
        //startActivity(intent);
    }
}
