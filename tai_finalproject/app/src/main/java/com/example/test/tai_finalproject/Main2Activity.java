package com.example.test.tai_finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    int[] subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final Button btn_return,btn_enter,btn_start;
        EditText edt_ans;
        TextView txt_input,txt_result,txt_num;

        btn_enter = (Button) findViewById(R.id.btn_enter);
        btn_return = (Button) findViewById(R.id.btn_return);
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_enter.setEnabled(false);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i;
                 for(i = 0;i<4;i++)
                 {
                     subject[i] =(int) (Math.random()*10);
                 }
                while (subject[0] == subject[1]  || subject[0] == subject[2] || subject[0] == subject[3])
                {
                    subject[0] = (int) (Math.random()*10);
                }
                while (subject[1] == subject[2] ||subject[1] == subject[3])
                {
                    subject[1] =  (int)(Math.random()*10);
                }
                while (subject[2] == subject[3])
                {
                    subject[2] = (int)(Math.random()*10);
                }
                btn_enter.setEnabled(true);
            }
        });
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
