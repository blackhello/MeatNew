package com.example.meat;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.preference.PreferenceActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Xml;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.serialization.SoapObject;

import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LoginActivity extends AppCompatActivity {

private Button btnlogin;
private EditText etcard;
private EditText etpassword;
private String sp;

private CreateUserDialog MyDialog;
CustomKeyboard mcustomKeyboard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin=(Button)findViewById(R.id.btnlogin);
        etcard=(EditText)findViewById(R.id.etcard);
        etpassword=(EditText)findViewById(R.id.etpassword);
        etcard.setText("60000200");


        //键盘
        mcustomKeyboard=new CustomKeyboard(this,R.id.keyboardview,R.id.keylayout);
        mcustomKeyboard.registerEditText(R.id.etpassword,true);

    }

    public void btnlogin(View view){
        final String card=etcard.getText().toString();
        final String password=etpassword.getText().toString();




        if(card.length()==0){
            ShowAlert("错误提示","请读取IC卡！");
            etcard.setText("60000200");
            return;
        }
        if(password.length()==0){
            ShowAlert("错误提示","请输入密码！");
            return;
        }
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();

/*        //添加参数
        HashMap<String, String> properties = new LinkedHashMap<String, String>();
        properties.put("CardNo", card);
        properties.put("PassWord", password);

        WebService.callWebService("GetLogin",properties, new WebService.WebServiceCallBack() {
    @Override
    public void callBack(SoapObject result) {
        if(result!=null){
            if(Boolean.parseBoolean(result.getProperty(0).toString())==true){
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }else{

                ShowAlert(getString(R.string.msgtitle),getString(R.string.msgcontent_passwordEorr));
                etpassword.setText("");
                return;
            }
        }else{
            ShowAlert(getString(R.string.msgtitle),getString(R.string.msgcontent_outline));
            etpassword.setText("");
            return;
        }
    }
});*/

    }

    private void ShowAlert(String title,String msg){
        //自定义弹出框，设置标题、内容、显示哪些按钮
        MyDialog=new CreateUserDialog(this,true,false,false,false);
        MyDialog.show();
        MyDialog.title.setText(title);
        MyDialog.message.setText(msg);
        //MyDialog.message.setTextColor(this.getResources().getColor(R.color.colorRed));
        MyDialog.setCancelable(false);//点击dialog以外的地方dialog不消失
    }

}
