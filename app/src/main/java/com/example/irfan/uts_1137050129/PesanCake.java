package com.example.irfan.uts_1137050129;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PesanCake extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Intent tangkap;
    TextView txtNamaCake;
    @BindView(R.id.txtNamaCake) TextView _txtNamaCake;
    @BindView(R.id.txtKategori) TextView _txtKategori;
    @BindView(R.id.edtPesan) EditText _edtPesan;

    @BindView(R.id.txtNamaPengirim) EditText _edtNamaPengirim;
    @BindView(R.id.btnSubmit)  Button _submit;
    String cake,pesan,to,pengirim,item;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_pesan);
        ButterKnife.bind(this);
        tangkap = getIntent();
        String paramHasil = tangkap.getStringExtra("param");

        txtNamaCake = (TextView) findViewById(R.id.txtNamaCake);

        txtNamaCake.setText(paramHasil);

        Spinner spinnerKatalog = (Spinner) findViewById(R.id.spinnerKategori);

        spinnerKatalog.setOnItemSelectedListener(this);

        final List<String> kategori = new ArrayList<String>();
        kategori.add("Friend");
        kategori.add("Family");
        kategori.add("Girlfriend");
        kategori.add("Boyfriend");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kategori);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKatalog.setAdapter(dataAdapter);

        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _txtKategori.setText(item);
                cake= _txtNamaCake.getText().toString();
                pesan = _edtPesan.getText().toString();
                to = _txtKategori.getText().toString();

                pengirim= _edtNamaPengirim.getText().toString();

                Bundle c = new Bundle();
                c.putString("kirimCake",cake);
                c.putString("kirimPesan",pesan);
                c.putString("kirimTo",to);
                c.putString("kirimPengirim",pengirim);

                Intent a = new Intent(PesanCake.this, HasilUcapan.class);
                a.putExtras(c);
                startActivity(a);







            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

        item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Select" + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}
