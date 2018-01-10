package com.example.meat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class JylistActivity extends AppCompatActivity {
    private Button btnadd;

    private CreateUserDialog MyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jylist);
    }

    public void btnback(View view){
        finish();
    }
    public void btnadd(View view){
        Intent intent=new Intent(this,JyActivity.class);
        startActivity(intent);
        finish();
    }

    public void btngq(View view){
        MyDialog=new CreateUserDialog(JylistActivity.this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("是否挂起此交易？");
        MyDialog.btn_Cancel.setVisibility(View.GONE);
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //写入挂起信息
                MyDialog.dismiss();
                Intent intent=new Intent(JylistActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
            }
        });

    }

    public void btnjs(View view){
        Intent intent=new Intent(this,JsskActivity.class);
        startActivity(intent);
        finish();

    }
    public void btncx(View view){
        MyDialog=new CreateUserDialog(JylistActivity.this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("是否撤销此交易？");
        MyDialog.btn_Cancel.setVisibility(View.GONE);
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
                Intent intent=new Intent(JylistActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
            }
        });

    }

    public void btndel(View view){
        MyDialog=new CreateUserDialog(JylistActivity.this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("确认删除此笔交易？");
        MyDialog.btn_Cancel.setVisibility(View.GONE);
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除操作


                MyDialog.dismiss();
            }
        });
        MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
            }
        });

    }
}
