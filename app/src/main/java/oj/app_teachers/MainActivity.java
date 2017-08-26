package oj.app_teachers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    UserSessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication s = new MyApplication();
        session = new UserSessionManager(getApplicationContext());
        if (!session.isUserLoggedIn()) {
            loginActivity();
        }
        setContentView(R.layout.activity_main);
        String loginID = session.getKeyLoginid();
        if (Objects.equals(s.selectRole(loginID), "student")) {
            viewAttendance();
        } else if (Objects.equals(s.selectRole(loginID), "teacher")) {
            takeAttendance();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                session.logoutUser();
                loginActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
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

    public void loginActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }
}
