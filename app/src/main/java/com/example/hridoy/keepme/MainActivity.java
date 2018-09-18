package com.example.hridoy.keepme;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    DBHelper mDBHelper;

    ArrayList<String> titleAL = new ArrayList<>();
    ArrayList<String> descriptionAL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.note_list_view);

        mDBHelper = new DBHelper(MainActivity.this);


        Cursor data = mDBHelper.getData();

        if (data.getCount() == 0){
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }else{
            while (data.moveToNext()){

                titleAL.add(data.getString(1));
                descriptionAL.add(data.getString(2));
            }
            NoteAdapter mAdapter = new NoteAdapter(MainActivity.this,titleAL,descriptionAL);
            mListView.setAdapter(mAdapter);
        }




    }


    public void create_note_btn_click(View view) {

        Intent intent = new Intent(MainActivity.this,CreateNoteActivity.class);
        startActivity(intent);

    }
}
