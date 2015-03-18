package com.example.babassmine.team_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by babassmine on 2/26/15.
 */
public class Personnel_adapter extends ArrayAdapter<Personnel>{

    public Personnel_adapter(Context context, List<Personnel> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Personnel person = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.oncall_detail, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.Name);
        TextView speciality = (TextView) convertView.findViewById(R.id.Speciality);
        TextView number = (TextView) convertView.findViewById(R.id.Number);
        Button call = (Button) convertView.findViewById(R.id.call);

        // Populate the data into the template view using the data object
        name.setText(person.NAME);
        call.setFocusable(false);
        call.setFocusableInTouchMode(false);
        speciality.setText(person.SPECIALITY);
        number.setText(person.NUMBER);
        // Return the completed view to render on screen
        return convertView;
    }

}
