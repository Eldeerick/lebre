package com.example.lebre;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

public class EmergenciaDialog extends Activity {

    private FrameLayout btnNao = findViewById(R.id.frmNao),
            btnSim = findViewById(R.id.frmSim);

    public void showDialog(final Activity activityFrom) {
        final Dialog dialog = new Dialog(activityFrom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.activity_emergenciadialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        btnNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle args = getIntent().getBundleExtra("Usuario");

                //Usuario usuario = (Usuario) args.getSerializable("BundleUsuario");

                Intent intent = new Intent(activityFrom, Signup.class);
                    //intent.putExtra("Usuario", args);
                dialog.cancel();
                startActivity(intent);
                    //activityFrom.finish();


            }
        });

        dialog.show();

    }
}
