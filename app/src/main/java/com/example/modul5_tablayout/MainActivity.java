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


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ac = findViewById(R.id.dataautocomplete);
        if (ac != null) {
            ac.addTextChangedListener(this);
            ac.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line));
        }

        TabHost tabHost = getTabHost();
        setNewTab(this, tabHost, "tab1", "UNIVERSITAS", R.drawable.ic_launcher_background, new Intent(this, Tab1.class));
        setNewTab(this, tabHost, "tab2", "FAKULTAS", R.drawable.ic_launcher_background, new Intent(this, Tab2.class));
        setNewTab(this, tabHost, "tab3", "PROGRAM STUDI", R.drawable.ic_launcher_background, new Intent(this, Tab3.class));

    }

    private void setNewTab(Context context, TabHost tabHost, String tag, String title, int icon, Intent intentid){
        TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(title, context.getResources().getDrawable(icon));
        tabSpec.setContent(intentid);
        tabHost.addTab(tabSpec);
    }



    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void afterTextChanged(Editable s) {}
}
