package com.example.modul5_tablayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Tab3 extends AppCompatActivity {
    private EditText lv;

    public String[] stringdatafak = {
            "Prodi Teknik Informatika (S1)",
            "Prodi Sistem Informasi (S1)",
            "Prodi Management Informatika (D3)",
            "Prodi Desain Komunikasi Visual (S1)",
            "Prodi Teknik Sipil (S1)"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab3);

        lv = findViewById(R.id.datalistview);
        if (lv != null) {
            lv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pilihfakultas(v);
                }
            });
        }

    }
    public void pilihfakultas(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Program Studi - Fakultas Ilmu Komputer \n Universitas Kuningan");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if (lv != null) {
                    lv.setText(stringdatafak[item]);
                    dialog.dismiss();
                }
            }
        }).show();
    }
}