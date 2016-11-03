package com.example.irfan.uts_1137050129;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	// Username, password edittext
	EditText txtUsername, txtPassword;
	TextView txtForgot;
	// login button
	Button btnLogin;
	// Session Manager Class
	SessionManager session;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
		session = new SessionManager(getApplicationContext());

        
        // Session Manager
        session = new SessionManager(getApplicationContext());                
        
        // Username, Password input text
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
		txtForgot = (TextView) findViewById(R.id.txtForgot);
        
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        // Login button
        btnLogin = (Button) findViewById(R.id.btnLogin);

        // Login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Get username, password from EditText
				String username = txtUsername.getText().toString();
				String password = txtPassword.getText().toString();
				
				// Check if username, password is filled				
				if(username.trim().length() > 0 && password.trim().length() > 0){
					// For testing puspose username, password is checked with sample data
					// username = test
					// password = test
					if(username.equals("admin") && password.equals("admin")){
						
						// Creating user login session
						// For testing i am stroing name, email as follow
						// Use user real data
						session.createLoginSession("irfan", "irfan.ramdhani@student.uinsgd.ac.id");
						
						// Staring MainActivity
						Intent i = new Intent(getApplicationContext(), MainActivity.class);
						startActivity(i);
						finish();
						
					}else{
						// username / password doesn't match
						Toast.makeText(LoginActivity.this,"Username atau Password Salah",Toast.LENGTH_SHORT).show();
					}				
				}else{
					// user didn't entered username or password
					Toast.makeText(LoginActivity.this,"Username atau Password Belum diisi",Toast.LENGTH_SHORT).show();
				}
				
			}
		});

		txtForgot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Toast.makeText(LoginActivity.this, "Username : admin "+ "Password : admin", Toast.LENGTH_SHORT).show();
			}
		});
    }        
}