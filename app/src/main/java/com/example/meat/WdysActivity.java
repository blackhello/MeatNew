package com.example.meat;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class WdysActivity extends AppCompatActivity {
    int mYear, mMonth, mDay;
    Button btn;
    TextView dateStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wdys);
    }
    public void btnback(View view){
        finish();
    }


    public void btnmx(View view){
        Intent intent=new Intent(WdysActivity.this,WdjyActivity.class);
        startActivity(intent);
        finish();

    }

    public void btnsk(View view){

        Intent intent=new Intent(WdysActivity.this,SkActivity.class);
        startActivity(intent);
        finish();
    }
}
