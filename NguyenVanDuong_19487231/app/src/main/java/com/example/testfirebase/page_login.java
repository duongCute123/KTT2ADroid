package com.example.testfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class page_login extends AppCompatActivity {
    FirebaseAuth auth;
    Button btn_log;
    EditText edit_l1,edit_l2;
    TextView txt_tao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        edit_l1=findViewById(R.id.edit_l1);
        edit_l2=findViewById(R.id.edit_lpass);
        txt_tao=findViewById(R.id.txt_tao);
        txt_tao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(page_login.this,register.class);
                startActivity(intent);
            }
        });
        btn_log=findViewById(R.id.btn_log);
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edit_l1.getText().toString();
                String pass=edit_l2.getText().toString();
                if(TextUtils.isEmpty(email)){
                    Toast.makeText(page_login.this, "Vui lòng nhập email", Toast.LENGTH_SHORT).show();
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(page_login.this, "Vui lòng nhập mật khẩu", Toast.LENGTH_SHORT).show();
                }
            auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(page_login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(page_login.this,page_trang_chu.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(page_login.this, "Lỗi đăng nhập rồi", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            }
        });
    }
}