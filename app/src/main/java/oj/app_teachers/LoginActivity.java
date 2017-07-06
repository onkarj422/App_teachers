package oj.app_teachers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editLogin;
    private EditText editPassword;
    private Button clickButton;
    String LoginID="admin";
    String Password="pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editLogin = (EditText) findViewById(R.id.LoginID);//r.id changed from edittext to LoginID
        editPassword = (EditText) findViewById(R.id.Password);//r.id.changed from edittext to Password
        clickButton = (Button) findViewById(R.id.button);
        clickButton.setOnClickListener( new View.OnClickListener() {


                                            @Override
                                            public void onClick(View view) {
                                                String loginId = editLogin.getText().toString().toLowerCase();
                                                String password = editPassword.getText().toString().toLowerCase();
                                                if (LoginID.equals(loginId) && Password.equals(password)) {
                                                    Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_LONG).show();
                                                   Intent i=new Intent(LoginActivity.this,SecondActivity.class);
                                                    startActivity(i);

                                                } else {
                                                    Toast.makeText(LoginActivity.this, "Please try again!!!", Toast.LENGTH_LONG).show();
                                                }
                                            }
    });
    }
}

            //public void login() {

            //}
        //}
    //}
//}

