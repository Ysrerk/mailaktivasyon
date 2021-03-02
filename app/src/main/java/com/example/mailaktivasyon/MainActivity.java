package com.example.mailaktivasyon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Models.Result;
import RestApi.ManagerAll;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText kullaniciadi,email,sifre;
    Button button;
    String kullaniciadiv,emailv,sifrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimlama();
        uyekayitistek();
    }
    public void tanimlama(){
        kullaniciadi=findViewById(R.id.kullaniciadi);
        email=findViewById(R.id.email);
        sifre=findViewById(R.id.sifre);
        button=findViewById(R.id.kaydet);
    }


    public void uyekayitistek(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kullaniciadiv=kullaniciadi.getText().toString();
                emailv=email.getText().toString();
                sifrev=sifre.getText().toString();

                ManagerAll managerAll=new ManagerAll();
                Call<Result> result=managerAll.getresult(kullaniciadiv,emailv,sifrev);
                result.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {



                        Toast.makeText(getApplicationContext(),"register completed",Toast.LENGTH_LONG).show();




                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"register did not complete",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                        intent.putExtra("email",emailv);
                        startActivity(intent);
                    }
                });
            }
        });


    }
}