package com.agel.kumar.akhil.doma.ccet_ipd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class SendMailActivity extends Activity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_mail);
		final Button send = (Button) this.findViewById(R.id.button1);



		send.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				Log.i("SendMailActivity", "Send Button Clicked.");

				/*String fromEmail = ((TextView) findViewById(R.id.editText1))
						.getText().toString();
				String fromPassword = ((TextView) findViewById(R.id.editText2))
						.getText().toString();
				String toEmails = ((TextView) findViewById(R.id.editText3))
						.getText().toString();
				List<String> toEmailList = Arrays.asList(toEmails
						.split("\\s*,\\s*"));
				Log.i("SendMailActivity", "To List: " + toEmailList);
				String emailSubject = ((TextView) findViewById(R.id.editText4))
						.getText().toString();
				String emailBody = ((TextView) findViewById(R.id.editText5))
						.getText().toString();
				new SendMailTask(SendMailActivity.this).execute(fromEmail,
						fromPassword, toEmailList, emailSubject, emailBody);*/


                String toEmails = ((TextView) findViewById(R.id.editText3))
                        .getText().toString();

				if(toEmails.equals("50kumarakhil@gmail.com")) {


					new SendMailTask(SendMailActivity.this).execute("ccet.ipd2k18@gmail.com",
							"qwertypad", Arrays.asList(toEmails.split("\\s*,\\s*")), "Your Username and Password for CCET-IPD", "USERNAME : akhil   -----------   PASSWORD : qwertypad");




                      SendMailActivity.this.startActivity(new Intent(SendMailActivity.this , Admin.class));
                       Toast.makeText(SendMailActivity.this , "username and password are mailed to 50ku******il@*****.com" , Toast.LENGTH_LONG).show();



				}
                else if(toEmails.equals("CSE")) {


                    new SendMailTask(SendMailActivity.this).execute("ccet.ipd2k18@gmail.com",
                            "qwertypad", Arrays.asList(toEmails.split("\\s*,\\s*")), "Your Username and Password for CCET-IPD", "USERNAME : cse@ccet  -----------  PASSWORD : cseisbest");



                    SendMailActivity.this.startActivity(new Intent(SendMailActivity.this , Admin.class));
                    Toast.makeText(SendMailActivity.this , "username and password are mailed to XXXXXX@*****.com" , Toast.LENGTH_SHORT).show();
                }
                else if(toEmails.equals("ECE")) {


                    new SendMailTask(SendMailActivity.this).execute("ccet.ipd2k18@gmail.com",
                            "qwertypad", Arrays.asList(toEmails.split("\\s*,\\s*")), "Your Username and Password for CCET-IPD", "USERNAME : ece@ccet  -----------  PASSWORD : eceisbest");



                    SendMailActivity.this.startActivity(new Intent(SendMailActivity.this , Admin.class));
                    Toast.makeText(SendMailActivity.this , "username and password are mailed to 50ku******il@*****.com" , Toast.LENGTH_SHORT).show();
                }
                else if(toEmails.equals("MECH")) {



                    new SendMailTask(SendMailActivity.this).execute("ccet.ipd2k18@gmail.com",
                            "qwertypad", Arrays.asList(toEmails.split("\\s*,\\s*")), "Your Username and Password for CCET-IPD", "USERNAME : mech@ccet  -----------  PASSWORD : mechisbest");


                    SendMailActivity.this.startActivity(new Intent(SendMailActivity.this , Admin.class));
                    Toast.makeText(SendMailActivity.this , "username and password are mailed to 50ku******il@*****.com" , Toast.LENGTH_SHORT).show();
                }
                else if(toEmails.equals("CIVIL")) {


                    new SendMailTask(SendMailActivity.this).execute("ccet.ipd2k18@gmail.com",
                            "qwertypad", Arrays.asList(toEmails.split("\\s*,\\s*")), "Your Username and Password for CCET-IPD", "USERNAME : civil@ccet  -----------  PASSWORD : civilisbest");


                    SendMailActivity.this.startActivity(new Intent(SendMailActivity.this , Admin.class));
                    Toast.makeText(SendMailActivity.this , "username and password are mailed to 50ku******il@*****.com" , Toast.LENGTH_SHORT).show();
                }
                else if(toEmails.equals("PRINCIPAL")) {


                    new SendMailTask(SendMailActivity.this).execute("ccet.ipd2k18@gmail.com",
                            "qwertypad", Arrays.asList(toEmails.split("\\s*,\\s*")), "Your Username and Password for CCET-IPD", "USERNAME : principal@ccet  -----------  PASSWORD : principalisbest");


                    SendMailActivity.this.startActivity(new Intent(SendMailActivity.this , Admin.class));
                    Toast.makeText(SendMailActivity.this , "username and password are mailed to 50ku******il@*****.com" , Toast.LENGTH_SHORT).show();
                }


                else{
                    Toast.makeText(SendMailActivity.this , "Email not registered" , Toast.LENGTH_SHORT).show();
                }
			}
		});
	}



}
