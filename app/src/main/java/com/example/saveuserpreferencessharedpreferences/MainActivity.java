package com.example.saveuserpreferencessharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.saveuserpreferencessharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    //
    public static final String Prefs_FileName = "usersNameFile";
    public static final String Key_UserName = "userName";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //
        SharedPreferences preferences = getSharedPreferences(Prefs_FileName, Context.MODE_PRIVATE);
        String userName = preferences.getString(Key_UserName, null);
        //
        if (userName!=null) {
            binding.mainTvTitle.setText(R.string.welcomeAppDear + userName);}
        //
        binding.mainBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = binding.mainEtDispName.getText().toString().trim();
                if (name.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            getString(R.string.valid_name_required), Toast.LENGTH_SHORT).show();
                }
                else {
                    binding.mainTvTitle.setText(R.string.welcomeApp + name + "!");
                    //
                    SharedPreferences.Editor editor = getSharedPreferences(Prefs_FileName, Context.MODE_PRIVATE).edit();
                    editor.putString(Key_UserName, name);
                    editor.commit();
                    //
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}