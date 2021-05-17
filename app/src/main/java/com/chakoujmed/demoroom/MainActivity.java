package com.chakoujmed.demoroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public  static  UserBb userDb;
Button btnajouter,btnVider;
EditText etName,etPass;
TextView tvListe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnajouter=findViewById(R.id.btnAjouter);
        btnVider=findViewById(R.id.btnVider);
        btnVider.setOnClickListener(this);
        btnajouter.setOnClickListener(this);
        etName=findViewById(R.id.etName);
        etPass=findViewById(R.id.etPass);
       tvListe=findViewById(R.id.tvListe);
        userDb= Room.databaseBuilder(this,UserBb.class,"dbUsers").allowMainThreadQueries().build();
        AfficherListe();
    }

    public void AfficherListe(){
        List<User> ls=MainActivity.userDb.getUserDao().getUsers();
        String res="";
        for (int i=0;i<ls.size();i++){
            res+="User name: "+ls.get(i).userName+" Password: "+ls.get(i).passWord+"\n";
        }
      tvListe.setText(res);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAjouter:
                String username=etName.getText().toString();
                String pass=etPass.getText().toString();
                User u=new User(username,pass);
                MainActivity.userDb.getUserDao().AjouterUtilisateur(u);
                Toast.makeText(MainActivity.this,"Utilisateur ajouté",Toast.LENGTH_LONG).show();
                AfficherListe();
                break;
        }

    }
}