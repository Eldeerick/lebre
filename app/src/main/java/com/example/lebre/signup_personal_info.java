package com.example.lebre;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup_personal_info extends AppCompatActivity {

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

                String cpf_content = cpf.getText().toString(); //11
                String nomeCompleto_content = nomeCompleto.getText().toString();
                String telefone_content = telefone.getText().toString();
                String estado_content = estado.getText().toString();
                String cidade_content = cidade.getText().toString();

                if (args != null) {
                    Usuario usuario = (Usuario) args.getSerializable("novoUsuario");

                    usuario.setUsuarioInfo(cpf_content, nomeCompleto_content, telefone_content, estado_content, cidade_content);

                    Gerenciamento_Arquivo.verificarPermissoes(signup_personal_info.this);

                    Gerenciamento_Arquivo.gravarUsuarioNoSD(getApplicationContext(), signup_personal_info.this, usuario.getAllInfo());

                    Intent i = new Intent(signup_personal_info.this, login.class);
                    startActivity(i);
                }
            }
        });
    }

    public void Alerta(Context context, String mensagem){
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }

}
