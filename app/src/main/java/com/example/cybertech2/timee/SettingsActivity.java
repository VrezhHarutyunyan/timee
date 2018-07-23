package com.example.cybertech2.timee;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    String [] language,character,download_settings;
    boolean checkedItems [] = {true,false};
    int itemSelected;
    TextView textView;
    String reset_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        toolbar = findViewById(R.id.toolbarSettings);
        listView = findViewById(R.id.listViewSettings);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

       ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this,R.array.settings_item,
              android.R.layout.simple_list_item_1);
       listView.setAdapter(arrayAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 if (position == 0){
                     final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                     builder.setTitle("Փոխել լեզուն");
                     language = getResources().getStringArray(R.array.language);
                     builder.setSingleChoiceItems(language, itemSelected, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });
                     builder.setPositiveButton("Հաստատել",null);
                     builder.setNegativeButton("Չեղարկել",null);
                   //  AlertDialog dialog = builder.create();
                     builder.show();
                 }
                 else if(position == 1 ){
                     final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                     builder.setTitle("Փոխել տառի չափը");
                     character = getResources().getStringArray(R.array.character);
                     builder.setSingleChoiceItems(character, itemSelected, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {

                         }
                     });
                     builder.setPositiveButton("Հաստատել",null);
                     builder.setNegativeButton("Չեղարկել",null);
                     builder.show();
                 }
                 else if (position == 2){
                     final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                     builder.setTitle("Փոխել տառի և ֆոնի գույնը");
                     builder.setPositiveButton("Հաստատել",null);
                     builder.setNegativeButton("Չեղարկել",null);
                     builder.show();
                 }
                 else if (position == 3){
                     final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                      builder.setTitle("Ներբեռնման կարգավորումները");
                      download_settings = getResources().getStringArray(R.array.download_settings);
                     builder.setMultiChoiceItems(download_settings, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Log.d("HomeActivity","clicked item index is " + which);
                         }
                     });
                     builder.setPositiveButton("Հաստատել",null);
                     builder.setNegativeButton("Չեղարկել",null);
                     builder.show();

                 }
                 else {
                     final AlertDialog.Builder builder = new AlertDialog.Builder(SettingsActivity.this);
                     builder.setTitle("Զրոյացնել կարգավորումները");
                     reset_settings = getResources().getString(R.string.reset_settings);
                     builder.setMessage(reset_settings);
                     builder.setPositiveButton("Հաստատել",null);
                     builder.setNegativeButton("Չեղարկել",null);
                     builder.show();

                 }
           }
       });

    }
}
