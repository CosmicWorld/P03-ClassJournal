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

public class DetailsAdapter extends ArrayAdapter<Details> {
    private ArrayList<Details> details;
    private Context context;
    private TextView tvWeek, tvGrade;

    public DetailsAdapter(Context context, int resource, ArrayList<Details> objects){
        super(context, resource, objects);
        details = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_details, parent, false);

        tvWeek = (TextView) rowView.findViewById(R.id.textViewWeek);
        tvGrade = (TextView)rowView.findViewById(R.id.textViewGrade);

        Details currentDetails = details.get(position);

        tvWeek.setText(currentDetails.getWeek());
        tvGrade.setText(currentDetails.getGrade());

        return rowView;
    }
}
