package com.example.democuoiky;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainLogin extends AppCompatActivity {
    FirebaseAuth mAuth;
    Button btnLogin;
    EditText editname;
    EditText editpass;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editname = findViewById(R.id.editname);
        editpass = findViewById(R.id.editpassword);
        btnLogin = findViewById(R.id.btnLogin);
        mAuth= FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }

    public void SignIn()
    {
        String email = String.valueOf(editname.getText());
        String password = String.valueOf(editpass.getText());
        if(email.isEmpty())
        {
            editname.setError("Not Empty Email!");
            editname.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editname.setError("Invalid Email!");
            editname.requestFocus();
            return;
        }
        if(password.isEmpty())
        {
            editpass.setError("Not Empty Email!");
            editpass.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(MainLogin.this,MainShow.class));
                        } else
                        {
                            new AlertDialog.Builder(MainLogin.this)
                                    .setTitle("Confirm")
                                    .setMessage("Sign Failed!")
                                    .setPositiveButton("YES",null).setNegativeButton("NO",null).show();
                        }
                    }
                });
        editname.setText("");
        editpass.setText("");
    }
}
