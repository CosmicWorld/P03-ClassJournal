package com.example.a15017381.p03_classjournal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by 15017381 on 5/5/2017.
 */

public class AddActivity extends AppCompatActivity {
    TextView tvWeek;
    RadioGroup rg;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        tvWeek = (TextView)findViewById(R.id.tvWeek);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        Intent i = getIntent();
        int info = (int) i.getSerializableExtra("add");

        setTitle("Add data for Week " + info);

        tvWeek.setText("Week " + info);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup)findViewById(R.id.radioGroup);
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selected);

                String grade = rb.getText().toString();

                Intent i = new Intent();
                i.putExtra("week", tvWeek.getText().toString());
                i.putExtra("grade", grade);

                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
