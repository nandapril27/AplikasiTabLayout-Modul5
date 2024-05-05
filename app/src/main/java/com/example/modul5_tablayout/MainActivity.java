package com.example.modul5_tablayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements TextWatcher {

    private AutoCompleteTextView ac;
    private EditText lv;
    public String[] stringdatafak = {
            "Prodi Teknik Informatika (S1)",
            "Prodi Sistem Informasi (S1)",
            "Prodi Management Informatika (D3)",
            "Prodi Desain Komunikasi Visual (S1)",
            "Prodi Teknik Sipil (S1)"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = findViewById(R.id.dataautocomplete);
        if (ac != null) {
            ac.addTextChangedListener(this);
            ac.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
        }

        TabHost tabHost = getTabHost();
        setNewTab(this, tabHost, "tab1", "UNIVERSITAS", R.drawable.ic_launcher_background, new Intent(this, Tab1.class));
        setNewTab(this, tabHost, "tab2", "FAKULTAS", R.drawable.ic_launcher_background, new Intent(this, Tab2.class));
        setNewTab(this, tabHost, "tab3", "PROGRAM STUDI", R.drawable.ic_launcher_background, new Intent(this, Tab3.class));

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

    private void setNewTab(Context context, TabHost tabHost, String tag, String title, int icon, Intent intentid){
        TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(title, context.getResources().getDrawable(icon));
        tabSpec.setContent(intentid);
        tabHost.addTab(tabSpec);
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

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void afterTextChanged(Editable s) {}
}
