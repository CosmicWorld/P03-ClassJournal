package com.example.a15017381.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 15017381 on 5/5/2017.
 */

public class DetailsActivity extends AppCompatActivity{
    int requestCodes = 1;
    Button btnWebsite;
    Button btnAdd;
    Button btnEmail;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Details> details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_grades);

        btnWebsite = (Button) findViewById(R.id.buttonInfo);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnEmail = (Button) findViewById(R.id.buttonEmail);

        lv = (ListView) this.findViewById(R.id.lvGrades);
        details = new ArrayList<>();
        aa = new DetailsAdapter(this, R.layout.row_details, details);
        lv.setAdapter(aa);

        Intent i = getIntent();
        String title = i.getStringExtra("module");
        setTitle("Info for " + title);

        btnWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.rp.edu.sg/Diploma_in_Mobile_Software_Development_(R47).aspx"));
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),AddActivity.class);
                i.putExtra("add", details.size() + 1);
                startActivityForResult(i, requestCodes);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {
                String week = data.getStringExtra("week");
                String grade = data.getStringExtra("grade");

                if(requestCode == requestCodes){
                    details.add(new Details(week, grade));
                    aa.notifyDataSetChanged();
                }
            }
        }
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String msg = "";
                for (int i = 0; i < details.size(); i++){
                    msg += details.get(i).getWeek() + ": DG: " + details.get(i).getGrade() + "\n";
                }
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        " ");
                email.putExtra(Intent.EXTRA_TEXT,
                        msg);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));
            }
        });
    }
}

