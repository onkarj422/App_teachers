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

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLogin = (EditText) findViewById(R.id.LoginID);
        editPassword = (EditText) findViewById(R.id.Password);
        Button clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginId = editLogin.getText().toString().toLowerCase();
                String password = editPassword.getText().toString().toLowerCase();
                Context context = getApplicationContext();
                MyApplication s = new MyApplication();
                if (Objects.equals(s.selectQuery(loginId), password)) {
                    Toast.makeText(context,"Login Successful",Toast.LENGTH_SHORT).show();
                    nextActivity();
                }else {
                    Toast.makeText(context,"Login Failed, Please Check Username or Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void nextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}