package com.example.meat;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

public class SkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sk);
    }

    public void btn_khzd(View v){
        Intent intent=new Intent(SkActivity.this,SkzdActivity.class);
        startActivity(intent);

    }

    public void btnmx(View v){
        Intent intent=new Intent(SkActivity.this,SkmxActivity.class);
        startActivity(intent);
    }

    public void btnback(View view){
        finish();
    }

}
