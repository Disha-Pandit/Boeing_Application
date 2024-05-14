package com.example.boeingapplication.main_activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.boeingapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnView = findViewById(R.id.bnView);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
       bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Intent intent;
               int id = item.getItemId();

               if (id == R.id.chemical) {
                   // Start the MenuActivity
                   intent = new Intent(getApplicationContext(), Chemical_Activity.class);
                   startActivity(intent);
                   overridePendingTransition(android.R.anim.slide_out_right);
                   return true;
               } else if (id == R.id.bin) {
                   intent = new Intent(getApplicationContext(), Bin_Activity.class);
                   startActivity(intent);
                   overridePendingTransition(android.R.anim.slide_out_right);
                   return true;
               } else if (id==R.id.setting) {
                   intent = new Intent(getApplicationContext(), Settings_Activity.class);
                   startActivity(intent);
                   overridePendingTransition(android.R.anim.slide_out_right);
                   return true;
               }
               else{
                   intent = new Intent(getApplicationContext(), Kit_Activity.class);
                   startActivity(intent);
                   overridePendingTransition(android.R.anim.slide_out_right);
                   return true;
               }

           }

       });
    }

    private void overridePendingTransition(int slideOutRight) {
    }
}
