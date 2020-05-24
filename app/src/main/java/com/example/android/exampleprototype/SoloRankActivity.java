package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SoloRankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solorank);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void HomeOnClick(View view){
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void MyPageOnClick(View view){
        Intent intent = new Intent(this, MyPageActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void SoloOnClick(View view){
        Intent intent = new Intent(this, SoloRankActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void GroupOnClick(View view) {
        Intent intent = new Intent(this, GroupRankActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
