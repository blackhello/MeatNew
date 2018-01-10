package com.example.meat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnjy,btnsk,btnjz,btnmy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnjy=(Button)findViewById(R.id.btn_jy);
        btnsk=(Button)findViewById(R.id.btn_sk);
        btnjz=(Button)findViewById(R.id.btn_jz);
        btnmy=(Button)findViewById(R.id.btn_my);

        btnjy.setOnClickListener(this);
        btnsk.setOnClickListener(this);
        btnjz.setOnClickListener(this);
        btnmy.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_jy:
                startActivity(new Intent(this,JyActivity.class));
                //finish();
                break;
            case R.id.btn_sk:
                startActivity(new Intent(this,SkActivity.class));
                //finish();
                break;
            case R.id.btn_jz:
                startActivity(new Intent(this,JzActivity.class));
                //finish();
                break;
            case R.id.btn_my:
                startActivity(new Intent(this,MyActivity.class));
                //finish();
                break;
        }
    }
}
