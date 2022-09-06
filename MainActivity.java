package com.example.livecrib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements ValueEventListener {
    TextView a,b, c, d, e;

    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference databaseReference = firebaseDatabase.getReference();
    private final DatabaseReference firstDatabase = databaseReference.child("senthil/Temperature");
    private final DatabaseReference secondDatabase = databaseReference.child("senthil/Humidity");
    private final DatabaseReference thirdDatabase = databaseReference.child("senthil/Diapers");
    private final DatabaseReference fourthDatabase = databaseReference.child("senthil/AirQuality");
    private final DatabaseReference fifthDatabase = databaseReference.child("senthil/Ultrasonic");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a= findViewById(R.id.texttemp);
        b= findViewById(R.id.texthumid);
        c= findViewById(R.id.textdiapers);
        d= findViewById(R.id.textairquality);
        e= findViewById(R.id.textultrasonic);


    }

    protected void onStart(){

        super.onStart();
        firstDatabase.addValueEventListener(this);
        secondDatabase.addValueEventListener(this);
        thirdDatabase.addValueEventListener(this);
        fourthDatabase.addValueEventListener(this);
        fifthDatabase.addValueEventListener(this);
    }

    @Override
    public void onDataChange( DataSnapshot dataSnapshot) {

        if(dataSnapshot.getValue(String.class)!=null){
            String key = dataSnapshot.getKey();
            if (key.equals("senthil/Temperature")){
                String Temp = dataSnapshot.getValue(String.class);
                a.setText(Temp);
            }
            if (key.equals("senthil/Humidity")){
                String Humid = dataSnapshot.getValue(String.class);
                b.setText(Humid);
            }
            if (key.equals("senthil/Diapers")) {
                String diapers = dataSnapshot.getValue(String.class);
                c.setText(diapers);
            }
            if (key.equals("senthil/AirQuality")) {
                String  diapers= dataSnapshot.getValue(String.class);
                c.setText(diapers);
            }
            if (key.equals("senthil/Ultrasonic")) {
                String ultrasonic = dataSnapshot.getValue(String.class);
                c.setText(ultrasonic);
            }
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }


}
