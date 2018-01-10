package com.example.meat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

public class SpaqActivity extends AppCompatActivity {
    private EditText edzsm;
    private GridLayout spanzs;
    CustomKeyboard mcustomKeyboard;
    private CreateUserDialog MyDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spaq);

        edzsm=(EditText)findViewById(R.id.edzsm);


        //键盘
        mcustomKeyboard=new CustomKeyboard(this,R.id.keyboardview,R.id.keylayout);
        mcustomKeyboard.registerEditText(R.id.edzsm,false);
    }
    public void btnback(View view){
        finish();
    }
    public void btspaq(View view){
        if (edzsm.getText().length()==0){
            //自定义弹出框，设置标题、内容、显示哪些按钮
            MyDialog=new CreateUserDialog(this,true,false,false,false);
            MyDialog.show();
            MyDialog.title.setText("友情提示");
            MyDialog.message.setText("请输入追溯码！");
            MyDialog.setCancelable(false);//点击dialog以外的地方dialog不消失
            return;
        }
        spanzs=(GridLayout)findViewById(R.id.spanzs);
        spanzs.setVisibility(view.getVisibility());
    }
}
