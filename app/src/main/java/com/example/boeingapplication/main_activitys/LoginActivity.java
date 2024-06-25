package com.example.boeingapplication.main_activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boeingapplication.R;

public class LoginActivity extends AppCompatActivity {
    EditText edusername,edpassword;
    TextView trouble;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Button button = findViewById(R.id.login);
        edusername=findViewById(R.id.username);
        edpassword=findViewById(R.id.password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    intent = new Intent(getApplicationContext(), BinActivity.class);
                    startActivity(intent);
                }
            });
        trouble=findViewById(R.id.trouble);
        trouble.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), CreateAccountActivity.class);
            startActivity(intent);
        });

    }
}