package com.example.seibah.monitoringnilai.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.seibah.monitoringnilai.Model.Model;
import com.example.seibah.monitoringnilai.Model.ModelGuru;
import com.example.seibah.monitoringnilai.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DaftarGuruController extends AppCompatActivity {
    ListView lv;
    FirebaseListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_guru_controller);
        lv = (ListView) findViewById(R.id.listview);
        Query query = FirebaseDatabase.getInstance().getReference().child("daftar_guru");
        FirebaseListOptions<ModelGuru> options = new FirebaseListOptions.Builder<ModelGuru>()
                .setLayout(R.layout.guru_list)
                .setQuery(query,ModelGuru.class)
                .build();
        adapter = new FirebaseListAdapter(options) {
            @Override
            protected void populateView(View v, Object model, int position) {
                TextView namaguru = v.findViewById(R.id.tv_namaguru);
                TextView alamatguru = v.findViewById(R.id.tv_alamatguru);
                TextView notelpon = v.findViewById(R.id.tv_noteleponguru);
                TextView mpl = v.findViewById(R.id.tv_matapelejaranguru);

                ModelGuru mdl = (ModelGuru) model;
                namaguru.setText(mdl.getNama_guru().toString());
                alamatguru.setText(mdl.getAlamat_guru().toString());
                notelpon.setText(mdl.getNo_telepon_guru().toString());
                mpl.setText(mdl.getMata_pelajaran().toString());

            }
        };
        lv.setAdapter(adapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}
