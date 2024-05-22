package com.example.boeingapplication.main_activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.model.BinCenter;
import com.example.boeingapplication.adapters.BinCenterAdapter;
import com.example.boeingapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class BinCenters extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BinCenterAdapter adapter;
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );


        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_bin_centers);





        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<BinCenter> binCenterList = prepareData();

        adapter = new BinCenterAdapter(binCenterList);
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(position -> {
            BinCenter binCenter = binCenterList.get(position);
            if (binCenter.getBinCenter().equals("ACFR")) {
                Intent intent = new Intent(BinCenters.this, AcfrActivity.class);
                startActivity(intent);
            }
        });




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.custom_back);
        toolbar.getChildAt(1).setTranslationY(30);
        toolbar.setPadding(0, 0, 0, 10);

        bnView = findViewById(R.id.bnView);
        bnView.setSelectedItemId(R.id.chemical);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int currentSelectedItemId = bnView.getSelectedItemId();


                Intent intent;
                int id = item.getItemId();

                if (id == R.id.chemical) {
                    // Start the MenuActivity
                    intent = new Intent(getApplicationContext(), ChemicalActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_out_right);
                    return true;
                } else if (id == R.id.bin) {
                    intent = new Intent(getApplicationContext(), BinActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_out_right);
                    return true;
                } else if (id==R.id.setting) {
                    intent = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_out_right);
                    return true;
                }
                else{
                    intent = new Intent(getApplicationContext(), KitActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.slide_out_right);
                    return true;
                }


            }


        });


    }

    private void overridePendingTransition(int slideOutRight) {
    }

    private List<BinCenter> prepareData() {
        List<BinCenter> binCenterList = new ArrayList<>();


        binCenterList.add(new BinCenter("ACFR", "6", "05/03/2024"));
        binCenterList.add(new BinCenter("AIB41", "7", "04/02/2024"));
        binCenterList.add(new BinCenter("AIBFR", "3", "04/22/2024"));
        binCenterList.add(new BinCenter("CHEM2", "1", "04/03/2024"));
        binCenterList.add(new BinCenter("DC11", "20", "05/03/2024"));
        binCenterList.add(new BinCenter("DC12", "1", "03/19/2024"));
        binCenterList.add(new BinCenter("DC13", "3", "04/02/2024"));
        binCenterList.add(new BinCenter("DC14", "1", "04/22/2024"));
        binCenterList.add(new BinCenter("GCU21", "2", "03/22/2024"));
        binCenterList.add(new BinCenter("GCUFR", "3", "04/18/2024"));
        binCenterList.add(new BinCenter("MOT1", "2", "03/21/2024"));
        binCenterList.add(new BinCenter("MRO31", "8", "03/22/2024"));
        binCenterList.add(new BinCenter("MROFR", "8", "03/11/2024"));
        binCenterList.add(new BinCenter("MRO31", "8", "03/22/2024"));
        binCenterList.add(new BinCenter("MROFR", "8", "03/11/2024"));

        return binCenterList;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // Handle back button press
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

    
    
}
