package com.thepensionapp.salondigitals;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    Button login_button;
    String username,password;
    EditText etUsername,etPassword;
    String login_ur=SalonUtil.getUrl()+"login";
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        builder=new AlertDialog.Builder(Login.this);
        login_button=(Button)findViewById(R.id.btnLoginAction);
        etUsername=(EditText)findViewById(R.id.etUserName);
        etPassword=(EditText)findViewById(R.id.etPassword);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=etUsername.getText().toString();
                password=etPassword.getText().toString();

                if(username.equals(" ") || password.equals(" ")){
                    builder.setTitle("Something Went Wrong");
                    displayAlert("Enter valid username and password");
                }else{

                    StringRequest stringRequest=new StringRequest(Request.Method.POST, login_ur,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    try {

                                        JSONObject jsonObject=new JSONObject(response);
                                        String status=jsonObject.getString("status");
                                        if(status.equals("failure")){
                                            builder.setTitle("Login Error...");
                                            displayAlert("we have an error when trying to login.....");
                                        }else{

                                            Intent intent=new Intent(Login.this,Dashboard.class);
                                            Bundle bundle=new Bundle();
                                            bundle.putString("salonName",jsonObject.getString("salonName"));
                                            bundle.putString("salonPhoneNumber",jsonObject.getString("phoneNumber"));


                                            intent.putExtras(bundle);
                                            startActivity(intent);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Login.this,"Error...",Toast.LENGTH_SHORT).show();



                        }
                    }){

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String>params=new HashMap<String, String>();
                            params.put("username",username);
                            params.put("password",password);
                            return params;
                        }
                    };
                    VolleySingleton.getVolleySingletonInstance(Login.this).addToRequestque(stringRequest);
                }

            }
        });

    }
    public void displayAlert(String message){

        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etUsername.setText("");
                etPassword.setText("");
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });
    }
}
