package com.thepensionapp.salondigitals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AwardLoyalty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award_loyalty);
    }


    protected void awardLoyalties(View view){

        String customerPhoneNumber=((EditText)findViewById(R.id.loyaltyPhoneNumber)).getText().toString();
        String points=((EditText)findViewById(R.id.loyaltyPoints)).getText().toString();
        Bundle bundle=getIntent().getExtras();


        String salonPhoneNumber=bundle.getString("salonPhoneNumber");

        PointsAwardingWorker PAW=new PointsAwardingWorker(this);
        PAW.execute(customerPhoneNumber,salonPhoneNumber,points);
    }
}
