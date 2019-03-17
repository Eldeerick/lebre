package com.example.lebre;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class CadastrarEmergencia extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_emergencia);

        tv = (TextView) findViewById(R.id.info);

        Bundle args = getIntent().getBundleExtra("Usuario");

        Usuario usuario = (Usuario) args.getSerializable("BundleUsuario");

        if(args != null) {
            tv.setText(usuario.getAllInfo());
        }
    }
}
