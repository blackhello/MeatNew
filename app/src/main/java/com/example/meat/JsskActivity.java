package com.example.meat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class JsskActivity extends AppCompatActivity {
    private EditText etcard;
    private EditText etpassword;
    CustomKeyboard mcustomKeyboard;
    private CreateUserDialog MyDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jssk);

        etpassword=(EditText)findViewById(R.id.etpassword);
        etcard=(EditText)findViewById(R.id.etcard);

        //键盘
        mcustomKeyboard=new CustomKeyboard(this,R.id.keyboardview,R.id.keylayout);
        mcustomKeyboard.registerEditText(R.id.etpassword,true);
    }
    public void btnback(View view){
        MyDialog=new CreateUserDialog(JsskActivity.this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("确定取消此次交易？");
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
                finish();

            }
        });
        MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
            }
        });
        MyDialog.setCancelable(false);//点击dialog以外的地方dialog不消失

    }
    public void btnqrjs(View view){
        if (etcard.getText().length()==0){
            Toast.makeText(this,"请刷买方交易卡！",Toast.LENGTH_SHORT).show();
            etcard.setText("20000001");
            return;
        }
        if (Integer.parseInt(etpassword.getText().toString())!=888888){
            Toast.makeText(this,"密码错误请重新输入！",Toast.LENGTH_SHORT).show();
            etpassword.setText("");
            return;
        }
        MyDialog=new CreateUserDialog(this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("是否继续其它交易操作？");
        MyDialog.btn_Cancel.setVisibility(View.GONE);
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
                Intent intent=new Intent(JsskActivity.this,JyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
                Intent intent=new Intent(JsskActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        MyDialog.setCancelable(false);
    }


/*    private void ShowAlert(String s, Activity activity){
        final AlertDialog dialog=new AlertDialog.Builder(activity).create();
        dialog.setMessage(s);
        dialog.show();
        WindowManager.LayoutParams params=dialog.getWindow().getAttributes();
        params.width=300;
        params.height=200;
        dialog.getWindow().setAttributes(params);
        final Timer t=new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(JsskActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                dialog.dismiss();
                t.cancel();
            }
        },2000);
    }*/
}
