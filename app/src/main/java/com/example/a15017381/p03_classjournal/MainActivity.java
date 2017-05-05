package com.example.a15017381.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModule;
    ArrayAdapter aa;
    ArrayList<Module> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModule = (ListView) findViewById(R.id.lvModule);

        al = new ArrayList<>();
        al.add(new Module("C302", "Web Services"));
        al.add(new Module("C347", "Android Programming II"));


        aa = new MainActivityAdapter(this, R.layout.row_main, al);
        lvModule.setAdapter(aa);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,
                        DetailsActivity.class);
                i.putExtra("module", al.get(position).getCode());
                startActivity(i);
            }
        });
    }
}
