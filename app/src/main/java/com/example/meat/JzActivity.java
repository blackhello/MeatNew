package com.example.meat;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatatypeMismatchException;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.serialization.SoapObject;
import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class JzActivity extends AppCompatActivity {
    private Spinner m_name = null;
    private CheckBox cb1,cb2,cb3,cb4,cb5;
    private EditText edzdje,edss;
    CustomKeyboard mcustomKeyboard;
    private CreateUserDialog MyDialog;

    //private List<String> provinceList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jz);
    }

    public void btn_jzkhzd(View v){
        Intent intent=new Intent(JzActivity.this,JzzdActivity.class);
        startActivity(intent);

    }

    public void btn_jzmx(View v){
        Intent intent=new Intent(JzActivity.this,JzmxActivity.class);
        startActivity(intent);
    }

    public void btnback(View view){
        finish();
    }

}
