package com.example.seibah.monitoringnilai.Model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.seibah.monitoringnilai.Controller.DaftarGuruController;
import com.example.seibah.monitoringnilai.Controller.ViewInformasiSiswa;
import com.example.seibah.monitoringnilai.Controller.ViewLogin;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by seibah on 08/05/18.
 */

public class Model extends Activity {
    int a = 0;
    ViewInformasiSiswa vi = new ViewInformasiSiswa(ViewInformasiSiswa.getContext());
    DatabaseReference myRef;
    String nama_siswa ;
    String nisn_siswa ;
    static Model instance;
    Boolean login = false;
    static String key;
    String tampungNama;
    static Context context;
    DaftarGuruController daftar;

    public String getTampungNama() {
        return tampungNama;
    }

    public void setTampungNama(String tampungNama) {
        this.tampungNama = tampungNama;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
    }
    public static Model getInstance(){
        return instance;
    }
    public boolean LoginDepan() {

        final ViewLogin vi = new ViewLogin(ViewLogin.getContext());

        myRef = FirebaseDatabase.getInstance().getReference("siswa");

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot uniqueKey : dataSnapshot.getChildren()
                        ) {
                    DataSnapshot a = uniqueKey.child("nama_siswa");
                    String b = a.getValue(String.class);
                    Log.i("coba",b);
                    Model.this.nama_siswa = vi.getNama_siswa();
                    DataSnapshot c = uniqueKey.child("nisn_siswa");
                    String d = c.getValue(String.class);
                    Model.this.nisn_siswa = vi.getNisn_siswa();
                    if (Model.this.nama_siswa.equals(b) && Model.this.nisn_siswa.equals(d)) {
                        setTampungNama(uniqueKey.child("nama_siswa").getValue(String.class));
                       setKey(uniqueKey.getKey());
                        viewInformasiSiswa();
                        viewNilaiAspekSikap();
                        //viewDaftarGuru();
                        login = true;


                    }

                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return login;

    }

    public void viewInformasiSiswa(){
        final SiswaModel siswa = new SiswaModel();
        DatabaseReference Info = FirebaseDatabase.getInstance().getReference("siswa");
     DatabaseReference childo = Info.child(getKey());
    childo.addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            setKey("dsdsds");
            siswa.setAgama(dataSnapshot.child("agama").getValue(String.class));
            Log.i("fdf",siswa.getAgama());
            siswa.setAlamat_siswa(dataSnapshot.child("alamat_siswa").getValue(String.class));
            siswa.setJenis_kelamin(dataSnapshot.child("jenis_kelamin").getValue(String.class));
            siswa.setKelas(dataSnapshot.child("kelas").getValue(String.class));
            siswa.setNama_ayah(dataSnapshot.child("nama_ayah").getValue(String.class));
            siswa.setNama_ibu(dataSnapshot.child("nama_ibu").getValue(String.class));
            siswa.setNama_siswa_info(dataSnapshot.child("nama_siswa").getValue(String.class));
            siswa.setNisn_siswa_info(dataSnapshot.child("nisn_siswa").getValue(String.class));
            siswa.setPekerjaan_ayah(dataSnapshot.child("pekerjaan_ayah").getValue(String.class));
            siswa.setPekerjaan_ibu(dataSnapshot.child("pekerjaan_ibu").getValue(String.class));
            siswa.setPendidikan_sebelumnya(dataSnapshot.child("pendidikan_sebelummya").getValue(String.class));
            siswa.setTempat_tanggal_lahir(dataSnapshot.child("tempat_tanggal_lahir").getValue(String.class));

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

    }

    public void viewNilaiAspekSikap(){
        final ModelNilaiAspekSIkap nas = new ModelNilaiAspekSIkap();
        DatabaseReference Info = FirebaseDatabase.getInstance().getReference("nilai_aspek_sikap");
        DatabaseReference childo = Info.child(getTampungNama());
        childo.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            nas.setBekerjaSama(dataSnapshot.child("bekerja sama").getValue(String.class));
            nas.setDisiplin(dataSnapshot.child("disiplin").getValue(String.class));
            nas.setPercayaDiri(dataSnapshot.child("percaya diri").getValue(String.class));
            nas.setSantun(dataSnapshot.child("santun").getValue(String.class));
            nas.setTeliti(dataSnapshot.child("teliti").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void viewDaftarGuru(){

        final DaftarGuruController vi = new DaftarGuruController();
        DatabaseReference info = FirebaseDatabase.getInstance().getReference("daftar_guru");
        info.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                daftar = new DaftarGuruController();
                for(DataSnapshot uniqueKey : dataSnapshot.getChildren()){
                    String b = uniqueKey.child("alamat_guru").getValue(String.class);
                    String c = uniqueKey.child("mata_pelajaran").getValue(String.class);
                    String d = uniqueKey.child("nama_guru").getValue(String.class);
                    String e = uniqueKey.child("no_telepon_guru").getValue(String.class);
                    Log.i("sdsds",e);
                    Log.i("sdsds",b);
                    Log.i("sdsds",c);
                    Log.i("sdsds",d);

                    a = a+1;

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i("E","error");
            }
        });

    }

    public Model(Context c){
        context = c;
    }
    public Model(){

    }

}
