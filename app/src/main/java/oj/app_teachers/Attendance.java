package oj.app_teachers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

public class Attendance extends AppCompatActivity {

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new UserSessionManager(getApplicationContext());
        MyApplication s = new MyApplication();
        String loginID = session.getKeyLoginid();
        if (Objects.equals(s.selectRole(loginID), "student")) {
            setContentView(R.layout.activity_attendance_view);
        } else if (Objects.equals(s.selectRole(loginID), "teacher")) {
            setContentView(R.layout.activity_attendance);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*
    @Override
    public void onBackPressed() {
        dashboardActivity();
    }
    */

    public void dashboardActivity() {
        Intent intent = new Intent(this, DashboardActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
