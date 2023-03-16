package com.example.saveuserpreferencessharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.saveuserpreferencessharedpreferences.databinding.ActivityMainBinding;
import com.example.saveuserpreferencessharedpreferences.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //
        SharedPreferences preferences = getSharedPreferences(MainActivity.Prefs_FileName, Context.MODE_PRIVATE);
        String userName = preferences.getString(MainActivity.Key_UserName, null);
        //
        binding.userActivityTvDispName.setText(R.string.welcomeAppDear + userName);
    }
}