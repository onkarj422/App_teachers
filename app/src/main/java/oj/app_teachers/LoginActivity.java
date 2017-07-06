package oj.app_teachers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLogin = (EditText) findViewById(R.id.editText);
        editPassword = (EditText) findViewById(R.id.editText1);
    }

    public void login() {
        String loginId = editLogin.getText().toString().toLowerCase();
        String password = editPassword.getText().toString().toLowerCase();
    }
}
