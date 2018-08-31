package com.thepensionapp.salondigitals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SalonRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_registration);





    }

    public void salonReg(View view){
        String salonName=((EditText)findViewById(R.id.etSalonName)).getText().toString();
        String salonPhoneNumber=((EditText)findViewById(R.id.etPhoneNumber)).getText().toString();
        String salonLocation=((EditText)findViewById(R.id.etSalonLocation)).getText().toString();
        String numberOfEmployees=((EditText)findViewById(R.id.etNumberOfEmployees)).getText().toString();
        String emailAddress=((EditText)findViewById(R.id.etEmailAddress)).getText().toString();


        SalonRegistrationWorker salonRegistrationWorker=new SalonRegistrationWorker(this);
        salonRegistrationWorker.execute(salonName,salonPhoneNumber,salonLocation,numberOfEmployees,emailAddress);


    }
}
