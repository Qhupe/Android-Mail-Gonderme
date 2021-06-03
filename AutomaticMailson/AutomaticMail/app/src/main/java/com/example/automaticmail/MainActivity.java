package com.example.automaticmail;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.Manifest;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity  {


    private EditText GoMail, subject, Mesaj;
    private Button button;

    public String allmessage;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GoMail = findViewById(R.id.GoMail);
        subject = findViewById(R.id.subject);
        Mesaj = findViewById(R.id.Mesaj);

        button = findViewById(R.id.btn);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
            }

        });
    }




    private void senEmail() {

            String mEmail = GoMail.getText().toString();
            String mSubject = subject.getText().toString();
            allmessage = Mesaj.getText().toString() ;
            String mMessage = allmessage;


            JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

            javaMailAPI.execute();

        GoMail.setText("");
        subject.setText("");
        Mesaj.setText("");



    }






}