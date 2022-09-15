package com.example.alivecrib;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;

    DatabaseReference dR1,dR2, dR3, dR4,dR5;

    private TextView retrieveTV1;
    private TextView retrieveTV2;
    private TextView retrieveTV3;
    private TextView retrieveTV4;
    private TextView retrieveTV5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();


        dR1 = firebaseDatabase.getReference("senthil/Temperature");
        dR2 = firebaseDatabase.getReference("senthil/Humidity");
        dR3 = firebaseDatabase.getReference("senthil/Ultrasonic");
        dR4 = firebaseDatabase.getReference("senthil/AirQuality");
        dR5 = firebaseDatabase.getReference("senthil/Diapers");

        retrieveTV1 = findViewById(R.id.textTemp);
        retrieveTV2 = findViewById(R.id.textHumid);
        retrieveTV3 = findViewById(R.id.textUltrasonic);
        retrieveTV4 = findViewById(R.id.textAirQuality);
        retrieveTV5 = findViewById(R.id.textDiapers);



        getdata();
    }

    private void getdata() {

        dR1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                retrieveTV1.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data1.", Toast.LENGTH_SHORT).show();
            }
        });

        dR2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                retrieveTV2.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data2.", Toast.LENGTH_SHORT).show();
            }
        });

        dR3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                retrieveTV3.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data3.", Toast.LENGTH_SHORT).show();
            }
        });

        dR4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                retrieveTV4.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data4.", Toast.LENGTH_SHORT).show();
            }
        });

        dR5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                retrieveTV5.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Fail to get data5.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
