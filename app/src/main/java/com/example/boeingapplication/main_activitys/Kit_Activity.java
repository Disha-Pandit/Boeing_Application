package com.example.boeingapplication.main_activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.adapters.KitAdapter;
import com.example.boeingapplication.model.KitItem;
import com.example.boeingapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Kit_Activity extends AppCompatActivity {
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kit);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        bnView = findViewById(R.id.bnView);
        bnView.setSelectedItemId(R.id.kit);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        // kit

        RecyclerView recyclerView = findViewById(R.id.kitrecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);


        List<KitItem> kitItem = prepareData();


        KitAdapter adapter = new KitAdapter(kitItem);
        recyclerView.setAdapter(adapter);


        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int currentSelectedItemId = bnView.getSelectedItemId();

                Intent intent;
                int id = item.getItemId();

                if (id == R.id.chemical) {

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
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = new Intent(this, Login_Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


    private void overridePendingTransition(int slideOutRight) {
    }
    private List<KitItem> prepareData() {
        List<KitItem> kitItem = new ArrayList<>();
        // Add items to the list (image resource ID and text)
        kitItem.add(new KitItem(R.drawable.kit_one, "Kit Check"));
        kitItem.add(new KitItem(R.drawable.kit_two, "Kit Filling"));
        kitItem.add(new KitItem(R.drawable.kit_three, "Kits"));
        kitItem.add(new KitItem(R.drawable.kit_four, "Dashboard"));
        // Add more items as needed
        return kitItem;
    }
}

