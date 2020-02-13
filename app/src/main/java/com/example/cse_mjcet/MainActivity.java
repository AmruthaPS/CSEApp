package com.example.cse_mjcet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Switch toggle;
    private static int SPLASH_TIME_OUT=4000;
    private CardView notice,faculty,res,ares,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkTheme);
        }
        else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggle = findViewById(R.id.toggle);
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            toggle.setChecked(true);
        }
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    recreate();
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    recreate();
                }
            }
        });
        notice= (CardView) findViewById(R.id.noticeId);
        faculty= (CardView) findViewById(R.id.facultyId);
        res= (CardView) findViewById(R.id.resourcesId);
        ares= (CardView) findViewById(R.id.adresId);
        about= (CardView) findViewById(R.id.aboutId);
        notice.setOnClickListener(this);
        faculty.setOnClickListener(this);
        res.setOnClickListener(this);
        ares.setOnClickListener(this);
        about.setOnClickListener(this);
        getSupportActionBar().hide();

    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.noticeId : i= new Intent(this,WebActivity.class);
                String s="https://cse-mjcet.wixsite.com/mj-cse";
                i.putExtra("URL",s);
                i.putExtra("dark",toggle.isChecked());
            startActivity(i); break;
            case R.id.facultyId : i=new Intent(this,faculty.class);
                i.putExtra("dark",toggle.isChecked());
                startActivity(i); break;
            case R.id.resourcesId :i =new Intent(this,reso.class);
                i.putExtra("dark",toggle.isChecked());
                startActivity(i); break;
            case R.id.adresId: i=new Intent(this,adres.class);
                i.putExtra("dark",toggle.isChecked());
                startActivity(i); break;
            case R.id.aboutId:i=new Intent(this, com.example.cse_mjcet.about.class);
                i.putExtra("dark",toggle.isChecked());
                startActivity(i); break;
            default: break;
        }
    }
}
