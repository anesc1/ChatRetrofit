package com.example.a1thefull.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnJoin(View view) {
        EditText text = (EditText)findViewById(R.id.userid);
        Intent intent = new Intent(this,ChatActivity.class);
        intent.putExtra("userid",text.getText().toString());
        startActivity(intent);
    }
}
