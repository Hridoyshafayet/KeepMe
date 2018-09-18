package com.example.hridoy.keepme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;

public class CreateNoteActivity extends AppCompatActivity {
    EditText titleET, descriptionET;

    DBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        titleET = findViewById(R.id.title_et);
        descriptionET = findViewById(R.id.description_et);

        myDBHelper = new DBHelper(CreateNoteActivity.this);


    }

    public void save_btn_click(View view) {

        String titleString = titleET.getText().toString();
        String descriptionString = descriptionET.getText().toString();

        if (TextUtils.isEmpty(titleString) || TextUtils.isEmpty(descriptionString)){

            Toast.makeText(this, "Insert a note first", Toast.LENGTH_SHORT).show();
        }else{


            myDBHelper.insertData(titleString,descriptionString);

            Intent intent = new Intent(CreateNoteActivity.this,MainActivity.class);
            startActivity(intent);


        }



    }
}
