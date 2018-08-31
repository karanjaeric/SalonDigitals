package com.thepensionapp.salondigitals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CustomerRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);
    }

    public void saveCustomer(View view){
        String customerName=((EditText)findViewById(R.id.customerName)).getText().toString();
        String customerPhoneNumber=((EditText)findViewById(R.id.customerPhoneNumber)).getText().toString();
        Bundle bundle=getIntent().getExtras();


        String salonPhoneNumber=bundle.getString("salonPhoneNumber");

        CustomerRegWorker customerRegWorker=new CustomerRegWorker(this);
        customerRegWorker.execute(customerName,customerPhoneNumber,salonPhoneNumber);

    }

}
