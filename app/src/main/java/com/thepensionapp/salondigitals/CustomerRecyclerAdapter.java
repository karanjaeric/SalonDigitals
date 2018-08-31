package com.thepensionapp.salondigitals;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ekaranja on 6/2/18.
 */

public class CustomerRecyclerAdapter extends RecyclerView.Adapter<CustomerRecyclerAdapter.MyViewHolder> {

    ArrayList<Customer>customers=new ArrayList<>();

    public CustomerRecyclerAdapter(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.customerName.setText(customers.get(position).getCustomerName());
        holder.customerPhoneNumber.setText(customers.get(position).getPhoneNumber());
        holder.points.setText(customers.get(position).getPoints());

    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView customerName;
        TextView customerPhoneNumber;
        TextView points;

        public MyViewHolder(View itemView) {

            super(itemView);
            customerName=(TextView)itemView.findViewById(R.id.cardViewName);
            customerPhoneNumber=(TextView)itemView.findViewById(R.id.cardViewPhoneNumber);
            points=(TextView)itemView.findViewById(R.id.cardViewPoints);

        }
    }
}
