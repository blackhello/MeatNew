package com.example.meat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.inputmethodservice.ExtractEditText;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by 王刚 on 2017/12/28.
 */

public class CreateUserDialog extends AlertDialog {
    ImageView img_back;
    Context context;
    Button btn_Ok,btn_No,btn_Cancel;
    Activity MyActivity;
    TextView title,message;
    Boolean iImgclose, ibtnok,ibtnno,ibtncancel;



    public CreateUserDialog(Activity activity,Boolean iImgclose,Boolean ibtnok,Boolean ibtnno,Boolean ibtncancel) {
        super(activity, R.style.MyDialog);
// TODO Auto-generated constructor stub
        this.MyActivity=activity;
        this.ibtnok=ibtnok;
        this.ibtncancel=ibtncancel;
        this.iImgclose=iImgclose;
        this.ibtnno=ibtnno;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.userdialog);

        initview();
    }
    private void initview() {
// TODO Auto-generated method stub
        img_back=(ImageView) findViewById(R.id.dialog_close);

        btn_Ok = (Button) findViewById(R.id.dialog_btn_ok);
        btn_No= (Button) findViewById(R.id.dialog_btn_no);
        btn_Cancel = (Button) findViewById(R.id.dialog_btn_cancel);

        title=(TextView) findViewById(R.id.tv_dialog_title);
        message=(TextView) findViewById(R.id.tv_dialog_message);

        if(ibtnok==false){btn_Ok.setVisibility(View.GONE);};
        if(ibtnno==false){btn_No.setVisibility(View.GONE);};
        if(ibtncancel==false){btn_Cancel.setVisibility(View.GONE);};
        if(iImgclose==false){img_back.setVisibility(View.GONE);};
        img_back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                CreateUserDialog.this.dismiss();
            }
        });

       /* btn_Ok.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                CreateUserDialog.this.dismiss();
            }
        });
        btn_No.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
        btn_Cancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

            }
        });
        */
    }
}
