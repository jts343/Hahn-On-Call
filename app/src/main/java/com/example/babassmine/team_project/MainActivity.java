package com.example.babassmine.team_project;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this is a dummy list used to hold temp data that is populate into the adapter
        String[] oncall_list = new String[3];
        oncall_list[0] = "John,Surgeon, 1234566";
        oncall_list[1] = "Mary,Physician, 3457734";
        oncall_list[2] = "Doe,Dentist,556576";
        //end dummy data
        //arraylist of the custom datatype 'Personnel'
        ArrayList<Personnel> list = new ArrayList<Personnel>();
        //populate the Array list
        for (int i=0; i<oncall_list.length; i++){
            list.add(new Personnel(oncall_list[i].split(",")[0],oncall_list[i].split(",")[1],oncall_list[i].split(",")[2]));
        }
        ListView lv = (ListView) findViewById(R.id.lv);
        //ArrayAdapter<String> adap = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked, oncall_list);
        Personnel_adapter adapter = new Personnel_adapter(this,list);
        lv.setAdapter(adapter);

        ListView call = (ListView) findViewById(R.id.lv);
        final TextView selected = (TextView) findViewById(R.id.selected);
        //when an item is clicked in the listview
        call.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Button b = (Button) findViewById(R.id.call);
                //makes the call button visible
                b.setVisibility(View.VISIBLE);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        makeCall();
                    }
                });


            }
        });

    }
    //make call method
    protected void makeCall() {
        Log.i("Make call", "");

        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:91-800-001-0101"));

        try {
            startActivity(phoneIntent);
            finish();
            Log.i("Finished making a call...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Call failed, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }

    protected void onResume(){
        super.onResume();
    }

    protected void onRestart(){
        super.onRestart();
    }

    protected void onStart(){
        super.onStart();
    }

    protected void onStop(){
        super.onStop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
