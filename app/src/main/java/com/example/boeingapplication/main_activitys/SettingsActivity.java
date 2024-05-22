package com.example.boeingapplication.main_activitys;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
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

public class SettingsActivity extends AppCompatActivity {
    BottomNavigationView bnView;
    ImageView imageView;
    private static final int REQUEST_PICK_IMAGE = 1;
    private RecyclerView recyclerView;
    private static SettingAdapter adapter1;
    private static List<SettingItem> settingItemList;
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
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        settingItemList = createSettingItemList();
        adapter1 = new SettingAdapter(settingItemList,this);
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
        Intent intent = new Intent(this, LoginActivity.class);
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

    private void showSelectCustomerDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_customer_dialog);
        RecyclerView recyclerViewCustomer = dialog.findViewById(R.id.recyclerViewcustomer);
        EditText editTextSearch = dialog.findViewById(R.id.editTextSearch);
        ImageView imageViewClear = dialog.findViewById(R.id.imageViewClear);
        TextView buttondone=dialog.findViewById(R.id.buttonDone);
        TextView buttonCancel = dialog.findViewById(R.id.buttonCancel);
        SelectCustomer.initRecyclerView(this, recyclerViewCustomer, editTextSearch,buttondone,dialog,buttonCancel);
        dialog.show();

    }

    public static void updateSettingItem(String user) {
        if (settingItemList != null) {
            settingItemList.get(2).setText(user);
            adapter1.notifyItemChanged(2);

        }
    }
}


