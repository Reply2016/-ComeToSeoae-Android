package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PointActivity extends AppCompatActivity {

    Button pointBtn1, pointBtn2, pointBtn3, pointBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        pointBtn1 = (Button)findViewById(R.id.coupon1);
        pointBtn2 = (Button)findViewById(R.id.coupon2);
        pointBtn3 = (Button)findViewById(R.id.coupon3);
        pointBtn4 = (Button)findViewById(R.id.coupon4);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //공깃밥 무료 버튼 클릭
    public void couponRiceOnClick(View view){
        //공깃밥 무료 쿠폰 팝업창 띄우기
        Intent intent = new Intent(this, PopupActivity1.class);
        startActivity(intent);
    }

    //음료수 무료 버튼 클릭
    public void couponBeverageOnClick(View view){
        //음료수 무료 쿠폰 팝업창 띄우기
        Intent intent = new Intent(this, PopupActivity2.class);
        startActivity(intent);
    }

    //소주 무료 버튼 클릭
    public void couponSojuOnClick(View view){
        //소주 무료 쿠폰 팝업창 띄우기
        Intent intent = new Intent(this, PopupActivity3.class);
        startActivity(intent);
    }

    //맥주 무료 버튼 클릭
    public void couponBeerOnClick(View view){
        //맥주 무료 쿠폰 팝업창 띄우기
        Intent intent = new Intent(this, PopupActivity4.class);
        startActivity(intent);
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
}
