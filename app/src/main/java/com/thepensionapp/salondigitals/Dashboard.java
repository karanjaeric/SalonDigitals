package com.thepensionapp.salondigitals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    TextView salonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        salonName=(TextView)findViewById(R.id.dashSalonName);

        Bundle bundle=getIntent().getExtras();
      //  String salonName=bundle.getString("salonName");
        salonName.setText("Welcome  "+bundle.getString("salonName"));

    }

    public void customerRegActivity(View view){
        Intent intent=new Intent("com.thepensionapp.salondigitals.CustomerRegistration");
        Bundle bundle=new Bundle();
        Bundle bundle1=getIntent().getExtras();

        bundle.putString("salonPhoneNumber",bundle1.getString("salonPhoneNumber"));
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void awardLoyalty(View view){
        Intent intent=new Intent("com.thepensionapp.salondigitals.AwardLoyalty");
        Bundle bundle=new Bundle();
        Bundle bundle1=getIntent().getExtras();

        bundle.putString("salonPhoneNumber",bundle1.getString("salonPhoneNumber"));
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void viewCustomers(View view){
        Intent intent=new Intent("com.thepensionapp.salondigitals.Customers");
        startActivity(intent);


    }
}
