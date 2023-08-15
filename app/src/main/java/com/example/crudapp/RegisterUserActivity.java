package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterUserActivity extends AppCompatActivity {
    EditText name,uname,pass,confPass;
    ClassForDBUsers udb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        name = (EditText) findViewById(R.id.etName);
        uname = (EditText) findViewById(R.id.etUName);
        pass = (EditText) findViewById(R.id.etPassword);
        confPass = (EditText) findViewById(R.id.eConfPassword);
        udb = new ClassForDBUsers(this);
    }

    public void onUserRegister(View v){
        String n = name.getText().toString();
        String uN = uname.getText().toString();
        String p = pass.getText().toString();
        String cp = confPass.getText().toString();

        System.out.println(n);
        System.out.println(uN);
        System.out.println(p);
        System.out.println(cp);

        if(p.equals(cp)){
            UserDetails ud = new UserDetails();
            ud.Name = n;
            ud.UName = uN;
            ud.PassW = p;
            udb.registerUser(ud);

            name.setText("");
            uname.setText("");
            pass.setText("");
            confPass.setText("");
            Toast.makeText(this,"Used Added Successfully, Please login !",Toast.LENGTH_LONG).show();
//            String a[];
//            a = udb.getOneDepartment(ud.UName);
//            int id = Integer.parseInt(a[1]);
//            System.out.println(id);
        }
    }
    public void onUserBack(View v){
        Intent obj;
        obj = new Intent("MAIN");
        startActivity(obj);
    }
}