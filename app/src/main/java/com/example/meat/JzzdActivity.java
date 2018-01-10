package com.example.meat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class JzzdActivity extends AppCompatActivity {

    private CheckBox cb1,cb2,cb3,cb4,cb5;
    private EditText edzdje,edss;
    CustomKeyboard mcustomKeyboard;
    private CreateUserDialog MyDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jzzd);


        edzdje=(EditText) findViewById(R.id.edzdje);
        edss=(EditText)findViewById(R.id.edss);


        //键盘
        mcustomKeyboard=new CustomKeyboard(this,R.id.keyboardview,R.id.keylayout);
        mcustomKeyboard.registerEditText(R.id.edss,false);


        //选择
        cb1=(CheckBox)findViewById(R.id.cb1);
        cb2=(CheckBox)findViewById(R.id.cb2);
        cb3=(CheckBox)findViewById(R.id.cb3);
        cb4=(CheckBox)findViewById(R.id.cb4);
        cb5=(CheckBox)findViewById(R.id.cb5);

        final DecimalFormat df=new DecimalFormat("######0.00");
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edzdje.setText(String.valueOf(Double.valueOf(edzdje.getText().toString()) +189.52));
                }else{
                    if(Double.parseDouble(edzdje.getText().toString())>0){
                        edzdje.setText(df.format(Double.valueOf(edzdje.getText().toString()) -189.52));
                    }else{
                        edzdje.setText("0.00");
                    }
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edzdje.setText(String.valueOf(Double.valueOf(edzdje.getText().toString()) +270.69));
                }else{
                    if(Double.parseDouble(edzdje.getText().toString())>0){
                        edzdje.setText(df.format(Double.valueOf(edzdje.getText().toString()) -270.69));
                    }else{
                        edzdje.setText("0.00");
                    }
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edzdje.setText(String.valueOf(Double.valueOf(edzdje.getText().toString()) +653.85));
                }else{
                    if(Double.parseDouble(edzdje.getText().toString())>0){
                        edzdje.setText(df.format(Double.valueOf(edzdje.getText().toString()) -653.85));
                    }else{
                        edzdje.setText("0.00");
                    }
                }
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edzdje.setText(String.valueOf(Double.valueOf(edzdje.getText().toString()) +325.64));
                }else{
                    if(Double.parseDouble(edzdje.getText().toString())>0){
                        edzdje.setText(df.format(Double.valueOf(edzdje.getText().toString()) -325.64));
                    }else{
                        edzdje.setText("0.00");
                    }
                }
            }
        });

        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    edzdje.setText(String.valueOf(Double.valueOf(edzdje.getText().toString()) +162.38));
                }else{
                    if(Double.parseDouble(edzdje.getText().toString())>0){
                        edzdje.setText(df.format(Double.valueOf(edzdje.getText().toString()) -162.38));
                    }else{
                        edzdje.setText("0.00");
                    }
                }
            }
        });

    }
    public void btnsk(View view){
        final String sjje=edss.getText().toString();
        if (sjje.length()==0){
            Toast.makeText(this,"请输入实结金额！", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Double.parseDouble(edss.getText().toString())==0){
            Toast.makeText(this,"请输入实结金额！", Toast.LENGTH_SHORT).show();
            return;
        }
        //自定义弹出框，设置标题、内容、显示哪些按钮
        MyDialog=new CreateUserDialog(this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("确认支付  武汉新鑫佳业商贸有限公司 货款\n\n货款金额："+ edss.getText().toString()+"元");
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
                Toast.makeText(JzzdActivity.this,"结账成功！",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(JzzdActivity.this,MainActivity.class);
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
        MyDialog.setCancelable(false);//点击dialog以外的地方dialog不消失
    }
    public void btnback(View view){
        finish();
    }
    public void btnmx(View v){
        Intent intent=new Intent(JzzdActivity.this,JzmxActivity.class);
        startActivity(intent);
    }
}
