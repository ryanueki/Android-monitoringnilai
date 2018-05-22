package com.example.seibah.monitoringnilai.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.seibah.monitoringnilai.Model.Model;
import com.example.seibah.monitoringnilai.R;
import com.example.seibah.monitoringnilai.Model.SiswaModel;


public class ViewInformasiSiswa extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView isi_nama_siswa;
    TextView isi_nisn_siswa;
    TextView isi_kelas_siswa;
    TextView isitempat_tanggal_lahir;
    TextView isijenis_kelamin;
    TextView isiagama;
    TextView isipendidikan_sebelumnya;
    TextView isialamat_siswa;
    TextView isinama_ayah;
    TextView isinama_ibu;
    TextView isipekerjaan_ayah;
    TextView isipekerjaan_ibu;
    static Context context;
    static Model mod;

    public static Context getContext() {
        return context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.isi_nama_siswa = this.findViewById(R.id.content_nama_siswa);
        this.isi_nisn_siswa = this.findViewById(R.id.isi_nisn_siswa);
        this.isi_kelas_siswa = this.findViewById(R.id.isi_kelas_siswa);
        this.isitempat_tanggal_lahir = this.findViewById(R.id.content_tempat_tanggal_lahir_siswa);
        this.isijenis_kelamin = this.findViewById(R.id.content_jenis_kelamin);
        this.isiagama = this.findViewById(R.id.content_agama);
        this.isipendidikan_sebelumnya = this.findViewById(R.id.content_pendidikan_sebelumnya);
        this.isialamat_siswa = this.findViewById(R.id.content_alamat_siswa);
        this.isinama_ayah = this.findViewById(R.id.content_ayah_siswa);
        this.isinama_ibu = this.findViewById(R.id.content_nama_ibu_siswa);
        this.isipekerjaan_ayah = this.findViewById(R.id.content_pekerjaan_ayah_siswa);
        this.isipekerjaan_ibu = this.findViewById(R.id.content_pekerjaan_ibu_siswa);

        SiswaModel mod = new SiswaModel();
            this.isi_nama_siswa.setText(mod.getNama_siswa_info());
            this.isi_nisn_siswa.setText(mod.getNisn_siswa_info());
            this.isi_kelas_siswa.setText(mod.getKelas());
            this.isitempat_tanggal_lahir.setText(mod.getTempat_tanggal_lahir());
            this.isijenis_kelamin.setText(mod.getJenis_kelamin());
            this.isiagama.setText(mod.getAgama());
            this.isipendidikan_sebelumnya.setText(mod.getPendidikan_sebelumnya());
            this.isialamat_siswa.setText(mod.getAlamat_siswa());
            this.isinama_ayah.setText(mod.getNama_ayah());
            this.isinama_ibu.setText(mod.getNama_ibu());
            this.isipekerjaan_ayah.setText(mod.getPekerjaan_ayah());
            this.isipekerjaan_ibu.setText(mod.getPekerjaan_ibu());


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


      @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_guru) {
            Intent i = new Intent(this,DaftarGuruController.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_daftar_kelas) {
            Log.i("coadd","f");
        } else if (id == R.id.nav_keterampilan) {

        } else if (id == R.id.nav_sikap) {
            Intent i = new Intent (this,ViewNilaiAspekSikap.class);
            startActivity(i);
        }
        else if (id == R.id.nav_pengetahuan) {

        }
        else if (id == R.id.nav_mata_pelajaran) {

        }
        else if (id == R.id.nav_logout) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public ViewInformasiSiswa(Context c){
        context = c;
    }
    public ViewInformasiSiswa(){

    }

    public void execute(){

    }


}
