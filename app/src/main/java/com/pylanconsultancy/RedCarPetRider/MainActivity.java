package com.pylanconsultancy.RedCarPetRider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the SDK
        Places.initialize(getApplicationContext(), "AIzaSyAqpkAb5yjwCVG_YPPtFbO-K-gcabxpLWQ");

// Create a new Places client instance
        PlacesClient placesClient = Places.createClient(this);

        Button buttonRegister = findViewById(R.id.button_register_phone);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Verify phone number and continue with registration process
                sendVerificationCode();
                Toast.makeText(MainActivity.this,"Verification initialized. Not fully implemented",Toast.LENGTH_SHORT).show();

            }
        });

        Button alreadyRegistered = findViewById(R.id.alreadyRegistered);
        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Take user to the login screen
                Intent loginIntent = new Intent(MainActivity.this, Login.class);
                startActivity(loginIntent);
            }
        });
        Button driveAppLink = findViewById(R.id.driveWithUs);
        driveAppLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent driverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=com.ubercab"));
                startActivity(driverIntent);
            }
        });


    }


    private void sendVerificationCode() {

    }

}
