package com.example.irfan.uts_1137050129;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HasilUcapan extends AppCompatActivity {


    SessionManager session;
    Button logout;
    @BindView(R.id.txtCake) TextView _tampilCake ;
    @BindView(R.id.txtTeman) TextView _tampilTeman ;
    @BindView(R.id.txtUcapan) TextView _tampilUcapan ;

    @BindView(R.id.txtPengirim) TextView _tampilPengirim ;

    String cake,teman, ucapan , pengirim;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_hasil);
        session = new SessionManager(getApplicationContext());
        logout = (Button) findViewById(R.id.btnLogout);
        session.checkLogin();

        ButterKnife.bind(this);

        Bundle c = getIntent().getExtras();

        cake = c.getString("kirimCake");
        teman = c.getString("kirimTo");
        ucapan = c.getString("kirimPesan");
        pengirim = c.getString("kirimPengirim");

        _tampilCake.setText(cake);
        _tampilTeman.setText(teman);
        _tampilUcapan.setText(ucapan);
        _tampilPengirim.setText(pengirim);

        ImageView gambar = (ImageView)findViewById(R.id.gambarKue);

        if (_tampilCake.getText().equals("Cheese Cake"))
        {
            gambar.setImageResource(R.drawable.cheesecake);
        }else  if (_tampilCake.getText().equals("Chocolate Cake"))
        {
            gambar.setImageResource(R.drawable.chocolatecake);
        }else  if (_tampilCake.getText().equals("Rainbow Cake"))
        {
            gambar.setImageResource(R.drawable.rainbowcake);
        }else  if (_tampilCake.getText().equals("Strawberry Cake"))
        {
            gambar.setImageResource(R.drawable.strawberrycake);
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                session.logoutUser();
                finish();
            }
        });
    }


}
