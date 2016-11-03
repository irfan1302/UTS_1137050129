package com.example.irfan.uts_1137050129;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter{
        private Activity activity;
        private int[] gambar;
        private String[] deskripsi;
        private LayoutInflater inflater;

        public CustomAdapter(Activity activity, int[] gambar, String[] deskripsi) {
            // TODO Auto-generated method stub
            this.activity = activity;
            this.gambar = gambar;
            this.deskripsi = deskripsi;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return deskripsi.length;
        }

        @Override
        public Object getItem(int location) {
            // TODO Auto-generated method stub
            return location;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public class Holder{
            TextView textDeskripsi;
            ImageView imageGambar;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            // TODO Auto-generated method stub

            Holder holder = new Holder();

            if (inflater == null)
                inflater = (LayoutInflater) activity
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            if (view == null)
                view = inflater.inflate(R.layout.nama_cake, null);

            // set text deskripsi
            holder.textDeskripsi = (TextView) view.findViewById(R.id.txt_deskripsi);
            holder.textDeskripsi.setText(deskripsi[i]);

            // set gambar
            holder.imageGambar = (ImageView) view.findViewById(R.id.img_gambar);
            holder.imageGambar.setImageResource(gambar[i]);

            return view;
        }

    }

