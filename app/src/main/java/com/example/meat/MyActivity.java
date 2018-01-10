package com.example.meat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import java.util.List;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnwdjy,btnwdys,btnwdyf,btnspaq,btnOut,btnOutSoft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btnwdjy=(Button)findViewById(R.id.btn_wdjy);
        btnwdys=(Button)findViewById(R.id.btn_wdys);
        btnwdyf=(Button)findViewById(R.id.btn_wdyf);
        btnspaq=(Button)findViewById(R.id.btn_spaq);
        btnOut=(Button)findViewById(R.id.btn_Out);
        btnOutSoft=(Button)findViewById(R.id.btn_Outsoft);

        btnwdjy.setOnClickListener(this);
        btnwdys.setOnClickListener(this);
        btnwdyf.setOnClickListener(this);
        btnspaq.setOnClickListener(this);
        btnOut.setOnClickListener(this);
        btnOutSoft.setOnClickListener(this);
    }
    public void btnback(View view){
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_wdjy:
                startActivity(new Intent(this,WdjyActivity.class));
                //finish();
                break;
            case R.id.btn_wdys:
                startActivity(new Intent(this,SkActivity.class));
                //finish();
                break;
            case R.id.btn_wdyf:
                startActivity(new Intent(this,JzActivity.class));
                //finish();
                break;
            case R.id.btn_spaq:
                startActivity(new Intent(this,SpaqActivity.class));
                //finish();
                break;
            case R.id.btn_Out:
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.btn_Outsoft:
                AgentApp.getInstance().onTerminate();
                break;
/*               android.os.Process.killProcess(android.os.Process.myPid());   //获取PID
                System.exit(0);   //常规java、c#的标准退出法，返回值为0代表正常退出
                //android.os.Process.killProcess(android.os.Process.myPid());*/
        }
    }
}
