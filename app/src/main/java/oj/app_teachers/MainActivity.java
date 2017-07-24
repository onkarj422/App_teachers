package oj.app_teachers;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        MyApplication s = new MyApplication();
        Intent intent = getIntent();
        String loginID = intent.getStringExtra("loginID");

        if (Objects.equals(s.selectRole(loginID), "student")) {
            ViewAttendance();
        }else if (Objects.equals(s.selectRole(loginID), "teacher")){
            TakeAttendance();
        }
    }

    public void TakeAttendance() {
        Button TakeButton =new Button(this);
        RelativeLayout myLayout = new RelativeLayout(this);
        TakeButton.setText("Take Attendance");
        myLayout.addView(TakeButton);
        setContentView(myLayout);
    }
    public void ViewAttendance() {
        Button ViewButton =new Button(this);
        RelativeLayout myLayout = new RelativeLayout(this);
        ViewButton.setText("View Attendance");
        myLayout.addView(ViewButton);
        setContentView(myLayout);
    }
}
