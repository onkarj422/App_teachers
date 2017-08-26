package oj.app_teachers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication s = new MyApplication();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        String loginID = intent.getStringExtra("loginId");

        if (Objects.equals(s.selectRole(loginID), "student")) {
            viewAttendance();
        } else if (Objects.equals(s.selectRole(loginID), "teacher")) {
            takeAttendance();
        }
    }

    public void takeAttendance() {
        Button takeButton = new Button(this);
        RelativeLayout myLayout = new RelativeLayout(this);
        takeButton.setText("Take Attendance");
        myLayout.addView(takeButton);
        setContentView(myLayout);
    }

    public void viewAttendance() {
        Button viewButton = new Button(this);
        RelativeLayout myLayout = new RelativeLayout(this);
        viewButton.setText("View Attendance");
        myLayout.addView(viewButton);
        setContentView(myLayout);
    }
}
