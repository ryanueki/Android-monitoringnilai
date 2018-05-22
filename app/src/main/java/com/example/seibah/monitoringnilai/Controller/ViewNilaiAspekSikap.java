package com.example.seibah.monitoringnilai.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.seibah.monitoringnilai.Model.ModelNilaiAspekSIkap;
import com.example.seibah.monitoringnilai.R;

public class ViewNilaiAspekSikap extends AppCompatActivity {

    TextView kerjaSama;
    ModelNilaiAspekSIkap vi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_nilai_aspek_sikap);
        this.kerjaSama = this.findViewById(R.id.content_bekerja_sama);
        vi = new ModelNilaiAspekSIkap();
        kerjaSama.setText(vi.getBekerjaSama());
    }
}
