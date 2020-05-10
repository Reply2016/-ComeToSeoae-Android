package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainPageActivity extends AppCompatActivity {

    private BackPressCloseHandler backPressCloseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        backPressCloseHandler = new BackPressCloseHandler(this);

        // home, mypage button
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);

        Button btn = (Button) findViewById(R.id.scan); // 적립하기
        Button btn2 = (Button) findViewById(R.id.rank); // 랭킹
        Button btn3 = (Button) findViewById(R.id.point); // 포인트 사용
        Button btn4 = (Button) findViewById(R.id.solo);
        Button btn5 = (Button) findViewById(R.id.group);
    }

    @Override
    public void onBackPressed() {
        backPressCloseHandler.onBackPressed(); // 뒤로가면 앱 종료
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

    public void RankOnClick(View view){
        Intent intent = new Intent(this, SoloRankActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void PointOnClick(View view){
        Intent intent = new Intent(this, PointActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
