package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MyPageActivity extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        backPressCloseHandler = new BackPressCloseHandler(this);

        // home, mypage button
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
    }
    //개인 정보 수정 버튼 클릭
    public void ModifyOnClick(View view){
        //SignUp 페이지로 이동
        Intent intent = new Intent(this, ModifyInfoActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            //Toast.makeText(this, "홈 이동", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainPageActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            return true;
        }
        if (id == R.id.mypage) {
            Toast.makeText(this, "마이페이지 이동", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MyPageActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}