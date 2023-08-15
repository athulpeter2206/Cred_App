package com.example.crudapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class UserHome extends AppCompatActivity {
    TextView name,Uname,id;
    String idpassed, namepassed, unamepassed,passwPassed;
    Toolbar tb;
    ClassForDBUsers udb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_home_page);
        name = (TextView) findViewById(R.id.eNameU);
        Uname = (TextView) findViewById(R.id.eUName);
        id = (TextView)findViewById(R.id.eId);
//        tb = (Toolbar) findViewById(R.id.toolbar);
//        tb.setTitle("Home");
//        setSupportActionBar(tb);
        Bundle b = getIntent().getExtras();
        idpassed = b.getString("id");
        namepassed = b.getString("name");
        unamepassed = b.getString("uname");
        passwPassed = b.getString("passw");
        id.setText("Id : "+idpassed);
        name.setText("Name : "+namepassed);
        Uname.setText("UserName : "+unamepassed);
        udb = new ClassForDBUsers(this);
        openOptionsMenu();
    }

    public void onUserCP(View view){
        Intent obj;
        obj = new Intent("act.changePass");
        obj.putExtra("id",idpassed);
        obj.putExtra("name",namepassed);
        obj.putExtra("uname",unamepassed);
        obj.putExtra("passw",passwPassed);
        startActivity(obj);
    }

    public void onLogout(View view){
        Intent obj;
        obj = new Intent("MAIN");
        startActivity(obj);
    }

//    @Override
//    public boolean onCreatePanelMenu(int featureId,Menu menu){
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.user_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int itemId = item.getItemId();
//        if (itemId == R.id.iChangePassword) {
//            Toast.makeText(this, "Change Password", Toast.LENGTH_LONG).show();
//            return true;
//        } else if (itemId == R.id.iLogout) {
//            Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.user_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        int itemId = item.getItemId();
//        if (itemId == R.id.iChangePassword) {
//            Toast.makeText(this, "Change Password", Toast.LENGTH_LONG).show();
//            return true;
//        } else if (itemId == R.id.iLogout) {
//            Toast.makeText(this, "Logout", Toast.LENGTH_LONG).show();
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//    }
}