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

import com.example.boeingapplication.adapters.AcfrAdapter;
import com.example.boeingapplication.model.AcfrItem;
import com.example.boeingapplication.decorations.BlackLineItemDecoration;
import com.example.boeingapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class AcfrActivity extends AppCompatActivity {
BottomNavigationView bnView;
    private RecyclerView recyclerView;
    private AcfrAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acfr);
        bnView = findViewById(R.id.bnView);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
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

//bottom navigatiopn work

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int currentSelectedItemId = bnView.getSelectedItemId();

                if (item.getItemId() == currentSelectedItemId) {

                    return false;
                }
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

            private void overridePendingTransition(int slideOutRight) {
            }

        });
    


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.custom_back);
        toolbar.getChildAt(1).setTranslationY(30);
        toolbar.setPadding(0, 0, 0, 10);
        recyclerView = findViewById(R.id.acfrrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        BlackLineItemDecoration blackLineItemDecoration = new BlackLineItemDecoration(this);
        recyclerView.addItemDecoration(blackLineItemDecoration);

        List<AcfrItem> dataItems = getData(); // Fetch data

        adapter = new AcfrAdapter(dataItems);
        recyclerView.setAdapter(adapter);
    }

    private List<AcfrItem> getData() {
        // This method fetches and returns data items for the RecyclerView
        List<AcfrItem> dataItems = new ArrayList<>();

        // Add data items (this should be replaced with actual data fetching logic)
        dataItems.add(new AcfrItem("SAFCN0003", "SCOTCH-WELD2214HT-NF-6-0Z", "40/60", "6", "Multiple",
                "28", "Multiple", "2", "2", "05/03/2024"));

        dataItems.add(new AcfrItem("SAFCN0042", "LOCTITE-406-20GM", "24/30", "   ", "    ",
                "25", "Multiple", "7", "7", "04/22/2024"));


        dataItems.add(new AcfrItem("SAFCN0045", "PERMABOND910-20GM", "2/4", "   ", "    ",
                "24", "Multiple", "0", "0", "04/11/2024"));


        dataItems.add(new AcfrItem("SAFCN0062", "PERMABOND-910-FS-0Z", "12/20", "   ", "    ",
                "19", "Multiple", "7", "7", "04/22/2024"));


        dataItems.add(new AcfrItem("SAFCN0068", "LOCTITE-EA109-320ML", "3/5", "   ", "    ",
                "21", "Multiple", "2", "2", "04/05/2024"));


        return dataItems;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }


