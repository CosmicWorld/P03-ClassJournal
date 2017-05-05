package com.example.a15017381.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017381 on 5/5/2017.
 */

public class MainActivityAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> module;
    private Context context;
    private TextView tvModuleCode, tvModuleName;

    public MainActivityAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        module = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row_main, parent, false);

        tvModuleCode = (TextView) row.findViewById(R.id.textViewModuleCode);
        tvModuleName = (TextView)row.findViewById(R.id.textViewModuleName);

        Module currentModule = module.get(position);

        tvModuleCode.setText(currentModule.getCode());
        tvModuleName.setText(currentModule.getName());

        return row;
    }
}
