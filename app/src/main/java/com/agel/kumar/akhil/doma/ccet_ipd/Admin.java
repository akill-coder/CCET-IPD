package com.agel.kumar.akhil.doma.ccet_ipd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    EditText user , pass;
    TextView forget;

    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        forget = (TextView)findViewById(R.id.forget);
        log = (Button)findViewById(R.id.login);


        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Admin.this, SendMailActivity.class);

                Admin.this.startActivity(myIntent);

            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((user.getText().toString().equals("akhil") && pass.getText().toString().equals("qwertypad") )
                        ||( user.getText().toString().equals("cse@ccet") && pass.getText().toString().equals("cseisbest"))
                        || (user.getText().toString().equals("ece@ccet") && pass.getText().toString().equals("eceisbest"))
                        || (user.getText().toString().equals("mech@ccet") && pass.getText().toString().equals("mechisbest"))
                        || (user.getText().toString().equals("civil@ccet") && pass.getText().toString().equals("civilisbest"))
                        || (user.getText().toString().equals("principal@ccet") && pass.getText().toString().equals("principalisbest"))){


                    // waiting for gulshan

                    Toast.makeText(Admin.this , "Welcome " + user.getText().toString() , Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(Admin.this , "Invalid username or password" , Toast.LENGTH_SHORT).show();

                    user.setText("");
                    pass.setText("");

                   pass.setError("Invalid");
                   // pass.requestFocus();
                    user.setError("Invalid");
                   // user.requestFocus();

                }

            }
        });








    }

   /* @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        // Your Dialog Code is here.

        Activity a = Admin.this;

        Intent myIntent = new Intent(a, MainActivity.class);
        //myIntent.putExtra("key", value); //Optional parameters
        // a.finish();
       Admin.this.startActivity(myIntent);
    }*/
}
