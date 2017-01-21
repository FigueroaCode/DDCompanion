package com.athon.hack.ddcompanion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegisterActivity extends AppCompatActivity {

    private Button registerButton;
    private EditText emailRegister;
    private EditText passwordRegister;
    private EditText verifyPasswordRegister;
    private EditText displayNameRegister;
    private FirebaseAuth authentication;

    private String emailRegisterStr;
    private String passwordRegisterStr;
    private String verifyPasswordRegisterStr;

    private void registrationFailure(){
        Toast.makeText(getApplicationContext(), "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
        passwordRegister.setText("");
        verifyPasswordRegister.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerButton = (Button)findViewById(R.id.registerButtonID);
        emailRegister = (EditText)findViewById(R.id.emailRegInputID);
        passwordRegister = (EditText)findViewById(R.id.passwordRegInputID);
        verifyPasswordRegister = (EditText)findViewById(R.id.verifyPasswordRegID);
        displayNameRegister = (EditText) findViewById(R.id.displayNameInput);
        authentication = FirebaseAuth.getInstance();

        authentication.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null) {
                    UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest
                            .Builder().setDisplayName(displayNameRegister.getText().toString()).build();
                    user.updateProfile(profileChangeRequest);
                }
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailRegisterStr = emailRegister.getText().toString();
                passwordRegisterStr = passwordRegister.getText().toString();
                verifyPasswordRegisterStr = verifyPasswordRegister.getText().toString();

                //Verify passwords match before attempting to create the account.
                if(verifyPasswordRegisterStr == passwordRegisterStr) {
                    authentication.createUserWithEmailAndPassword(emailRegisterStr, passwordRegisterStr)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "Account Created", Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        registrationFailure();
                                    }
                                }
                            });
                }else{
                    registrationFailure();
                }
            }
        });//End of onClickListener.

    }
}
