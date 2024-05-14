package com.example.boeingapplication.main_activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.boeingapplication.R;
import com.example.boeingapplication.adapters.SettingAdapter;
import com.example.boeingapplication.model.SettingItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class Settings_Activity extends AppCompatActivity {
BottomNavigationView bnView;
    ImageView imageView;
    Intent intent;
    private static final int REQUEST_PICK_IMAGE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
       imageView = findViewById(R.id.user_image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open gallery here
                openGallery();
            }
        });

        TextView txt = findViewById(R.id.logoutTextView);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(intent);
            }
        });





        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<SettingItem> settingItemList = createSettingItemList();
        SettingAdapter adapter1 = new SettingAdapter(settingItemList);
        recyclerView.setAdapter(adapter1);











        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        bnView = findViewById(R.id.bnView);
        bnView.setSelectedItemId(R.id.setting);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);
        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

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


    //open gallery method
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            // Handle the selected image here
            Uri selectedImageUri = data.getData();
            imageView.setImageURI(selectedImageUri);

        }
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






    private List<SettingItem> createSettingItemList() {
        List<SettingItem> settingItemList = new ArrayList<>();
        settingItemList.add(new SettingItem(R.drawable.icon1, "Change Password",R.drawable.ar));
        settingItemList.add(new SettingItem(R.drawable.icon2, "About",R.drawable.ar));
        settingItemList.add(new SettingItem(R.drawable.icon3, "042531 - SAFRAN ELECTRICAL & POWER UK LTD SAFRAN POWER UK LTD",R.drawable.ar));
        settingItemList.add(new SettingItem(R.drawable.icon4, "Face ID",R.drawable.toggle));
        settingItemList.add(new SettingItem(R.drawable.icon5, "App Version",R.drawable.version));
        settingItemList.add(new SettingItem(R.drawable.icon6, "Online Verification",R.drawable.toggle));
        settingItemList.add(new SettingItem(R.drawable.icon7, "Feedback",R.drawable.ar));
        settingItemList.add(new SettingItem(R.drawable.icon8, "Privacy Policy",R.drawable.ar));
        settingItemList.add(new SettingItem(R.drawable.icon8, "EU Data Privacy Notice",R.drawable.ar));
        settingItemList.add(new SettingItem(R.drawable.icon9, "Terms of Use",R.drawable.ar));
        return settingItemList;
    }
}


