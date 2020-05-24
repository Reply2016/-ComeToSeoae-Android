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

        /*Button btn = (Button) findViewById(R.id.scan); // 적립하기
        Button btn2 = (Button) findViewById(R.id.rank); // 랭킹
        Button btn3 = (Button) findViewById(R.id.point); // 포인트 사용
        Button btn4 = (Button) findViewById(R.id.solo);
        Button btn5 = (Button) findViewById(R.id.group);
        Button btn6 = (Button) findViewById(R.id.home);
        Button btn7 = (Button) findViewById(R.id.mypage);*/
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
