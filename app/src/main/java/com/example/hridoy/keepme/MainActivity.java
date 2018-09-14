package com.example.hridoy.keepme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void create_note_btn_click(View view) {

        Intent intent = new Intent(MainActivity.this,CreateNoteActivity.class);
        startActivity(intent);

    }
}
