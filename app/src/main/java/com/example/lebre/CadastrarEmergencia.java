package com.example.lebre;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CadastrarEmergencia extends AppCompatActivity {

    private Spinner tipo_ocorrencia;
    private Button enviar_ocorrencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_emergencia);

        enviar_ocorrencia = findViewById(R.id.enviar_ocorrencia_);
        tipo_ocorrencia = findViewById(R.id.spinner_ocorrencia);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tipos_ocorrencia,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo_ocorrencia.setAdapter(adapter);

        tipo_ocorrencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextColor(Color.WHITE); //muda cor do texto selecionado
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        enviar_ocorrencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tipoOcorrencia = tipo_ocorrencia.getSelectedItem().toString();
                String estado = "Aguardando Resposta";

                if(tipoOcorrencia.equals("Selecione")){

                }else{
                    Gerenciamento_Arquivo.gravarOcorrenciaSD(tipoOcorrencia);

                    //Bundle args = new Bundle();
                    //args.putSerializable("BundleOcorrencia", tipoOcorrencia);

                    Intent intent = new Intent();
                    intent.putExtra("IntentOcorrencia", tipoOcorrencia);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });

    }
}
