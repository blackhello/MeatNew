package com.example.meat;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WdjyActivity extends AppCompatActivity implements View.OnTouchListener  {
    private EditText datastart;
    private EditText dataend;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wdjy);

        datastart = (EditText)findViewById(R.id.datastart);
        dataend = (EditText)findViewById(R.id.dataend);

        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        Date curDate =new Date(System.currentTimeMillis());//获取当前时间
        String str = formatter.format(curDate);
        datastart.setText(str);
        dataend.setText(str);

        datastart.setOnTouchListener(this);
        dataend.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            View view=View.inflate(this,R.layout.date_dialog,null);
            final DatePicker datePicker=(DatePicker) view.findViewById(R.id.date_picker);
            builder.setView(view);

            Calendar cal=Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());

            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

            if(v.getId()==R.id.datastart){
                final int inType = datastart.getInputType();
                datastart.setInputType(InputType.TYPE_NULL);
                datastart.onTouchEvent(event);
                datastart.setInputType(inType);
                datastart.setSelection(datastart.getText().length());

                builder.setTitle("选取起始时间");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        datastart.setText(sb);
                        dataend.requestFocus();
                        dialog.cancel();
                    }
                });
            }else if(v.getId()==R.id.dataend){
                int inType = dataend.getInputType();
                dataend.setInputType(InputType.TYPE_NULL);
                dataend.onTouchEvent(event);
                dataend.setInputType(inType);
                dataend.setSelection(dataend.getText().length());

                builder.setTitle("选取结束时间");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        dataend.setText(sb);
                        datastart.requestFocus();
                        dialog.cancel();
                    }
                });
            }
            Dialog dialog=builder.create();
/*
            dialog.getDatePicker().setMaxDate();  //设置日期最大值
            dialog.getDatePicker().setMinDate();*/
            dialog.show();
        }
return true;
    };


    public void btnback(View view){
        finish();
    }

}
