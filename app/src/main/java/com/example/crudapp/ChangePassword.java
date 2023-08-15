package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ChangePassword extends AppCompatActivity {
    TextView name,uname;
    EditText pass,confpass;
    String idpassed, namepassed, unamepassed,passwPassed;
    ClassForDBUsers udb;UserDetails u = new UserDetails();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);
        name = (TextView) findViewById(R.id.etUName);
        uname = (TextView) findViewById(R.id.etName);
        pass = (EditText) findViewById(R.id.etPassword);
        confpass = (EditText) findViewById(R.id.eConfPassword);
        Bundle b = getIntent().getExtras();
        idpassed = b.getString("id");
        namepassed = b.getString("name");
        unamepassed = b.getString("uname");
        passwPassed = b.getString("passw");

        name.setText("Name : "+namepassed);
        uname.setText("UserName : "+unamepassed);

        udb = new ClassForDBUsers(this);
    }

    public void onUserChangePassword(View v){
        if((pass.getText().toString()).equals(confpass.getText().toString())){
            u.Id = Integer.parseInt(idpassed);
            u.Name = namepassed;
            u.UName = unamepassed;
            u.PassW = pass.getText().toString();
            int res = udb.updatePassword(u);
            if(res==1){
                Toast.makeText(this,"Password changed Successfully",Toast.LENGTH_LONG).show();
                Intent obj;
                obj = new Intent("act.userHome");
                startActivity(obj);
            }else{
                Toast.makeText(this,"Password changed Failed!",Toast.LENGTH_LONG).show();
            }
        }

    }
    public void onUserCancel(View v){
        Intent obj;
        obj = new Intent("act.userHome");
        startActivity(obj);
    }
}