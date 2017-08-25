package oj.app_teachers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.UUID;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;
    public String MESSAGE = null;
    UserSessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new UserSessionManager(getApplicationContext());
        if (session.checkLogin(getApplicationContext())) {
            mainActivity();
        }
        setContentView(R.layout.activity_login);
        editLogin = (EditText) findViewById(R.id.LoginID);
        editPassword = (EditText) findViewById(R.id.Password);
        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication s = new MyApplication();
                Context context = getApplicationContext();
                String loginid = editLogin.getText().toString().toLowerCase();
                String password = editPassword.getText().toString().toLowerCase();
                String sessionKeyPass = UUID.randomUUID().toString();

                MESSAGE = loginid;
                if (Objects.equals(s.selectPassword(loginid), password)) {
                    session.createLoginSession(loginid, sessionKeyPass);
                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show();
                    mainActivity();
                } else {
                    Toast.makeText(context, "Login Failed, Please Check Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void mainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("loginId", MESSAGE);
        startActivity(intent);
    }
}