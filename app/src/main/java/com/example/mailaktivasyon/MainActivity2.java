package com.example.mailaktivasyon;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity2 extends AppCompatActivity {
    EditText email,kod;
    Button aktifyap;
    String kodv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tanimla();
        emailal();
        aktifyap();
    }
    public void tanimla(){
        email=findViewById(R.id.email2);
        kod=findViewById(R.id.code2);
        aktifyap=findViewById(R.id.aktifyap);
    }

    public  void emailal(){

        Bundle bundle=getIntent().getExtras();
        String emailvv=bundle.getString("email");
        email.setText(emailvv);
    }

    public void aktifyap(){

        aktifyap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ManagerAll managerAll=new ManagerAll();
                kodv=kod.getText().toString();
                Call<Result>call=managerAll.aktiffyap(email.getText().toString(),kodv);
                call.enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {

                        Toast.makeText(getApplicationContext(),"aktif yapilxxdd",Toast.LENGTH_LONG).show();
                        email.setText("");
                        kod.setText("");

                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"aktif yapildii",Toast.LENGTH_LONG).show();
                        email.setText("");
                        kod.setText("");


                    }
                });
            }
        });
    }
}