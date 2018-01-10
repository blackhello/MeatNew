package com.example.meat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

public class JyActivity extends AppCompatActivity {
    private Spinner m_goods = null;
    private EditText eddj,edzz,edhk,edhj,eddzc,edyj;
    private Button btn_lj;

    private CreateUserDialog MyDialog;
    CustomKeyboard mcustomKeyboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AgentApp.getInstance().addActivity(this);
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jy);

        m_goods=(Spinner) findViewById(R.id.spgoods);

        String goods="猪颈肉,猪颊肉,梅花肉,前排肉,里脊肉,五花肉,臀尖肉,坐臀肉,弹子肉,前腿";
        String[] arrgoods=goods.split(",");
        ArrayAdapter<String> adgoods;
        adgoods=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrgoods);
        adgoods.setDropDownViewResource(android.R.layout.simple_spinner_item);
        m_goods.setAdapter(adgoods);
        m_goods.setVisibility(View.VISIBLE);

        eddj=(EditText)findViewById(R.id.eddj);
        edzz=(EditText)findViewById(R.id.edzz);
        edhk=(EditText)findViewById(R.id.edhk);
        edhj=(EditText)findViewById(R.id.edhj);
        eddzc=(EditText)findViewById(R.id.eddzc);
        edyj=(EditText)findViewById(R.id.edyj);

        edzz.setText(eddzc.getText());

        //键盘
        mcustomKeyboard=new CustomKeyboard(this,R.id.keyboardview,R.id.keylayout);
        mcustomKeyboard.registerEditText(R.id.eddj,false);

//是否累加
        btn_lj=(Button) findViewById(R.id.btn_lj);
        btn_lj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //自定义弹出框，设置标题、内容、显示哪些按钮
                MyDialog=new CreateUserDialog(JyActivity.this,false,true,true,true);
                MyDialog.show();
                MyDialog.title.setText("友情提示");
                MyDialog.message.setText("重量是否累加！");
                MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.dismiss();
                        edzz.setText(String.valueOf(Double.parseDouble(edzz.getText().toString())+Double.parseDouble(eddzc.getText().toString())));
                        GetPrice();

                    }
                });
                MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.dismiss();
                        edzz.setText(eddzc.getText().toString());
                        GetPrice();
                    }
                });
                MyDialog.btn_Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDialog.dismiss();
                        GetPrice();
                    }
                });
                MyDialog.setCancelable(false);//点击dialog以外的地方dialog不消失
            }
        });

     //单价改变
        eddj.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                GetPrice();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


//计算货款、佣金、合计
    public void GetPrice(){
        //总重，单价
        Double dj;
        if (eddj.length()==0){dj=0.00;}else{
            dj=Double.parseDouble(eddj.getText().toString());
        }
        Double zzl=Double.parseDouble(edzz.getText().toString());
        Double hk=Math.round(dj * zzl * 100) / 100d;
        //佣金率；
        Double yjl=0.03;
        Double yj=Math.round(zzl * yjl * 100) / 100d;

        edhk.setText(String.valueOf(hk));
        edyj.setText("0.00");
        edhj.setText(String.valueOf(hk + Double.parseDouble(edyj.getText().toString())));
    }

    public void btnback(View view){
        MyDialog=new CreateUserDialog(JyActivity.this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("确定取消此笔交易？");
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
    public void btnbuy(View view){
        if (Double.parseDouble(eddj.getText().toString())==0){
            Toast.makeText(this,"请输入产品单价！",Toast.LENGTH_SHORT).show();
            return;
        }

        if (Double.parseDouble(eddj.getText().toString())==0){
            Toast.makeText(this,"请输入产品单价！",Toast.LENGTH_SHORT).show();
            return;
        }

        MyDialog=new CreateUserDialog(JyActivity.this,false,true,true,false);
        MyDialog.show();
        MyDialog.title.setText("友情提示");
        MyDialog.message.setText("是否继续其它商品交易？");
        MyDialog.btn_Cancel.setVisibility(View.GONE);
        MyDialog.btn_Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //加入购物信息
                MyDialog.dismiss();
                Intent intent=new Intent(JyActivity.this,JyActivity.class);
                startActivity(intent);
                finish();

            }
        });
        MyDialog.btn_No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.dismiss();
                //直接转入结账界面
                Intent intent=new Intent(JyActivity.this,JylistActivity.class);
                startActivity(intent);
                finish();
            }
        });
        MyDialog.setCancelable(false);//点击dialog以外的地方dialog不消失




    }
}
