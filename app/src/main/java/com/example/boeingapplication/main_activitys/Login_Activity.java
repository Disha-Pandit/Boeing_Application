package com.example.boeingapplication.main_activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boeingapplication.R;
import com.example.boeingapplication.main_activitys.Bin_Activity;
import com.example.boeingapplication.main_activitys.Create_Account_Activity;

public class Login_Activity extends AppCompatActivity {
    EditText edusername,edpassword;
    Button button;
    TextView trouble;
Button login;
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
        intent = new Intent(getApplicationContext(), Bin_Activity.class);
        startActivity(intent);
    }
});
trouble=findViewById(R.id.trouble);
trouble.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getApplicationContext(), Create_Account_Activity.class);
        startActivity(intent);
    }
});

    }
}