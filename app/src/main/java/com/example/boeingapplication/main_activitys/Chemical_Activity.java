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

import com.example.boeingapplication.adapters.ChemicalAdapter;
import com.example.boeingapplication.model.ChemicalItem;
import com.example.boeingapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Chemical_Activity extends AppCompatActivity {
    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns
        List<ChemicalItem> chemicalItemList = createChemicalItemList();
        ChemicalAdapter adapter = new ChemicalAdapter(chemicalItemList,this);
        recyclerView.setAdapter(adapter);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        bnView = findViewById(R.id.bnView);
        bnView.setSelectedItemId(R.id.chemical);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
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

    private List<ChemicalItem> createChemicalItemList() {
        List<ChemicalItem> chemicalItemList = new ArrayList<>();


        chemicalItemList.add(new ChemicalItem(R.drawable.image_one, "Chemical Details Info"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_two, "Chemicals On Hand"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_three, "Chemical Recieving"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_four, "Chemical Consumption"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_five, "Scan History"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_six, "Chemical Scrap Request"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_seven, "Scrap Approval"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_eight, "Scrap History"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_nine, "View Certification"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_ten, "Work In Progress"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_eleven, "Bin To Bin Transfer"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_twelve, "Force Bin Replenishment"));
        chemicalItemList.add(new ChemicalItem(R.drawable.image_thirteen, "Dashboard"));


        return chemicalItemList;
    }

}
