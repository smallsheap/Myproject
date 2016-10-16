package com.example.user.gras;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText gammer;
    TextView status;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;
    Button play;
    TextView name;
    TextView winner;
    TextView myMora;
    TextView computerMora;

    int mora_gammer =-1;
    String[] MoraString = {"剪刀","石頭","布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gammer = (EditText) findViewById(R.id.ganer);
        status = (TextView) findViewById(R.id.status);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        play = (Button) findViewById(R.id.button);
        name =(TextView) findViewById(R.id.name);
        winner =(TextView) findViewById(R.id.winner);
        myMora =(TextView) findViewById(R.id.myMora);
        computerMora =(TextView) findViewById(R.id.computerMora);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.radioButton:
                        mora_gammer=0;
                        break;
                    case R.id.radioButton2:
                        mora_gammer=1;
                        break;
                    case R.id.radioButton3:
                        mora_gammer=2;
                        break;
                }

            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gammer.getText().toString().equals(""))
                    status.setText("請選擇玩家名稱");
                else if (mora_gammer==-1)
                    status.setText("請選擇出拳的種類");
                else{
                    name.setText(gammer.getText());
                    myMora.setText(MoraString[mora_gammer]);
                    int mora_computer = (int) (Math.random()*3);
                    computerMora.setText(MoraString[mora_computer]);

                    if ((mora_gammer == 0 && mora_computer == 1)||(mora_gammer == 1 && mora_computer==2 )){
                        winner.setText("電腦");
                        status.setText("可惜，電腦獲勝了");
                    } else if(mora_gammer == mora_computer){
                        winner.setText("平局");
                        status.setText("可惜!再試一場看看");
                    } else{
                        winner.setText(gammer.getText());
                        status.setText("恭喜你獲勝了！");
                    }

                }


            }
        });


    }


}
