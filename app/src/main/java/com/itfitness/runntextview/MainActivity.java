package com.itfitness.runntextview;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itfitness.runntextview.widget.RunnTextView;

public class MainActivity extends AppCompatActivity {
    private RunnTextView activityAnimtestTv;
    private EditText activityAnimtestEt;
    private Button activityAnimtestBt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityAnimtestTv = (RunnTextView) findViewById(R.id.activity_main_tv);
        activityAnimtestEt = (EditText) findViewById(R.id.activity_main_et);
        activityAnimtestBt = (Button) findViewById(R.id.activity_main_bt);
        activityAnimtestBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityAnimtestTv.setMoney(Float.valueOf(activityAnimtestEt.getText().toString().trim()));
            }
        });
    }
}
