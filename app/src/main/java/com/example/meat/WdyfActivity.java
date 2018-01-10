package com.example.meat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class WdyfActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wdyf);
    }
    public void btnback(View view){
        finish();
    }

    public void btnmx(View view){
        Intent intent=new Intent(WdyfActivity.this,WdjyActivity.class);
        startActivity(intent);
        finish();

    }

    public void btnyf(View view){
        Intent intent=new Intent(WdyfActivity.this,JzActivity.class);
        startActivity(intent);
        finish();
    }
}
