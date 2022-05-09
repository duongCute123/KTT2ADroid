package com.example.testfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
    Button btn_register;
    EditText edit_r1,edit_r2;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edit_r1=findViewById(R.id.edit_r1);
        edit_r2=findViewById(R.id.edit_r2);
        btn_register=findViewById(R.id.btn_regis);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edit_r1.getText().toString();
                String pass=edit_r2.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(register.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(register.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(register.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(register.this,page_login.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(register.this, "Lỗi tạo tài khoản", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}