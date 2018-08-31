package com.thepensionapp.salondigitals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Customers extends AppCompatActivity {

    String [] customers={"Eric Karanja","Grace Muthoni","Essy Njeru","Queency Muthoni"};
    String [] phoneNumbers={"070232833","0763639865","07566544986","074556144"};

    int [] points={10,20,30,40};
    Toolbar toolbar;
    RecyclerView recyclerView;
    CustomerRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Customer> customerList=new ArrayList<>();
        setContentView(R.layout.activity_customers);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        int count=0;
        for(String customer:customers){
            customerList.add(new Customer(customer,phoneNumbers[count],points[count]));
            count ++;


        }
        adapter=new CustomerRecyclerAdapter(customerList);
        recyclerView.setAdapter(adapter);
    }
}
