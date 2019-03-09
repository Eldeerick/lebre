package com.example.lebre;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao_recuperar_senha = (Button) findViewById(R.id.button2);
        botao_recuperar_senha.setPaintFlags(botao_recuperar_senha.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}
