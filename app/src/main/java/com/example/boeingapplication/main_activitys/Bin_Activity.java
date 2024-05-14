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

import com.example.boeingapplication.adapters.BinAdapter;
import com.example.boeingapplication.model.BinItem;
import com.example.boeingapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Bin_Activity extends AppCompatActivity {
BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        List<BinItem> binItemList = createBinItemList();
        BinAdapter adapter = new BinAdapter(binItemList);
        recyclerView.setAdapter(adapter);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        bnView = findViewById(R.id.bnView);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
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
    private List<BinItem> createBinItemList() {
        List<BinItem> binItemList = new ArrayList<>();
        binItemList.add(new BinItem(R.drawable.img_one_bin, "Replenish Bin"));
        binItemList.add(new BinItem(R.drawable.img_two_bin, "Bin & Part Details"));
        binItemList.add(new BinItem(R.drawable.img_three_bin, "Scan History"));
        binItemList.add(new BinItem(R.drawable.img_four_bin, "Notes"));
        binItemList.add(new BinItem(R.drawable.img_five_bin, "Notes Management"));
        binItemList.add(new BinItem(R.drawable.img_six_bin, "Stock Request"));
        binItemList.add(new BinItem(R.drawable.img_seven_bin, "View Certification"));
        binItemList.add(new BinItem(R.drawable.img_eight_bin, "Dashboard"));
        return binItemList;
    }
}

