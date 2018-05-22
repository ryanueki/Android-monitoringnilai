package com.example.seibah.monitoringnilai.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.seibah.monitoringnilai.Model.Model;
import com.example.seibah.monitoringnilai.R;

public class ViewLogin extends AppCompatActivity {
    EditText username;
    EditText password;
    String s;
    Button Login;
    Model model;
    Boolean login = false;
    static Context context;

    public static Context getContext() {
        return context;
    }

    public static String nama_siswa ;
    public static String nisn_siswa ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        this.username = this.findViewById(R.id.nama_siswa_login);
        this.password = this.findViewById(R.id.nisn_siswa_login);
        this.Login = this.findViewById(R.id.login);
        model = new Model();

        Login.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {

                setNama_siswa(username.getText().toString());
                setNisn_siswa(password.getText().toString());
                ViewLogin.this.nama_siswa = getNama_siswa();
                ViewLogin.this.nisn_siswa = getNisn_siswa();

                if (ViewLogin.this.model.LoginDepan()) {
                    Intent i = new Intent(ViewLogin.this, ViewInformasiSiswa.class);
                    startActivity(i);
                    finish();
                }

            }

        });

    }
    public String getNama_siswa()
    {
        return this.nama_siswa;
    }

    public void setNama_siswa(String nama_siswa)
    {
        this.nama_siswa = nama_siswa;
    }

    public String getNisn_siswa()
    {
        return this.nisn_siswa;
    }
    public void setNisn_siswa(String nisn_siswa)
    {
        this.nisn_siswa = nisn_siswa;
    }

    public ViewLogin(Context c){
        context = c;
    }
    public ViewLogin(){

    }
}






