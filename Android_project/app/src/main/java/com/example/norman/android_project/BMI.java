package com.example.norman.android_project;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {


    EditText h;
    EditText w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        h = (EditText)findViewById(R.id.editText2);                           // 取得身高物件
        w = (EditText)findViewById(R.id.editText3);                           // 取得體重物件
        Button submit = (Button)findViewById(R.id.button10);             // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少

        // 按下按鈕 觸發事件
        submit.setOnClickListener(new Button.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                if ( !("".equals(h.getText().toString())
                        || "".equals(w.getText().toString())) )
                {
                    float fh = Float.parseFloat(h.getEditableText().toString());      // 取得 身高輸入值
                    float fw = Float.parseFloat(w.getEditableText().toString());     // 取得 體重輸入值
                    float fresult;                                     // BMI值 計算結果
                    TextView result = (TextView)findViewById(R.id.textView11);// 取得 顯示結果 物件
                    fh = fh/100; // 計算BMI
                    fh = fh*fh;  // 計算BMI

                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                    fresult = fw/fh;                                // 計算BMI
                    result.setText(nf.format(fw/fh) +"");           // 顯示BMI計算結果
                    TextView dia = (TextView)findViewById(R.id.textView13);// 取得 顯示診斷 物件

                    // 診斷結果 顯示
                    if (fresult<18.5)
                        dia.setText("過  輕");
                    else if (18.5 <= fresult && fresult< 24)
                        dia.setText("正  常");
                    else if (24 <=fresult && fresult < 27)
                        dia.setText("過  重");
                    else if (27 <=fresult && fresult < 30)
                        dia.setText("輕度肥胖");
                    else if (30 <= fresult && fresult < 35)
                        dia.setText("中度肥胖");
                    else if (fresult >= 35)
                        dia.setText("重度肥胖");
                }
            }
        });

        Button button12 = (Button)findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(BMI.this , MainActivity.class);
                startActivity(intent);
            }
        });






        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
