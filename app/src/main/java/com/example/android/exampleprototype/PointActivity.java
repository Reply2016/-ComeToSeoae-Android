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

    Button btn1t, btn2t, btn5t, btn10t, btn20t, btn50t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        // home, mypage button
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);

        Button.OnClickListener btnListener = new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(PointActivity.this, PopupActivity.class);
                startActivity(intent);
                // switch문 써서 point마다 다른 창 띄우기
            }
        };
        btn1t = (Button)findViewById(R.id.btn1t);
        btn2t = (Button)findViewById(R.id.btn2t);
        btn5t = (Button)findViewById(R.id.btn5t);
        btn10t = (Button)findViewById(R.id.btn10t);
        btn20t = (Button)findViewById(R.id.btn20t);
        btn50t = (Button)findViewById(R.id.btn50t);
        btn1t.setOnClickListener(btnListener);
        btn2t.setOnClickListener(btnListener);
        btn5t.setOnClickListener(btnListener);
        btn10t.setOnClickListener(btnListener);
        btn20t.setOnClickListener(btnListener);
        btn50t.setOnClickListener(btnListener);
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
/*
    public void use1000p(){
        //((PopupActivity)PopupActivity.popupContext).n = R.layout.activity_popup1;
        //((PopupActivity)PopupActivity.popupContext).returnPointNum(R.layout.activity_popup1);
        Intent intent = new Intent(PointActivity.this, PopupActivity.class);
        startActivity(intent);
    }
    public void use2000p(){
        //((PopupActivity)PopupActivity.popupContext).n = R.layout.activity_popup2;
        //((PopupActivity)PopupActivity.popupContext).returnPointNum(R.layout.activity_popup2);
        Intent intent = new Intent(PointActivity.this, PopupActivity.class);
        startActivity(intent);
    }
    public void use5000p(){
        //((PopupActivity)PopupActivity.popupContext).n = R.layout.activity_popup3;
        //((PopupActivity)PopupActivity.popupContext).returnPointNum(R.layout.activity_popup3);
        Intent intent = new Intent(PointActivity.this, PopupActivity.class);
        startActivity(intent);
    }
    public void use10000p(){
        //((PopupActivity)PopupActivity.popupContext).n = R.layout.activity_popup4;
        //((PopupActivity)PopupActivity.popupContext).returnPointNum(R.layout.activity_popup4);
        Intent intent = new Intent(PointActivity.this, PopupActivity.class);
        startActivity(intent);
    }
    public void use20000p(){
        //((PopupActivity)PopupActivity.popupContext).n = R.layout.activity_popup5;
        //((PopupActivity)PopupActivity.popupContext).returnPointNum(R.layout.activity_popup5);
        Intent intent = new Intent(PointActivity.this, PopupActivity.class);
        startActivity(intent);
    }
    public void use50000p(){
        //((PopupActivity)PopupActivity.popupContext).n = R.layout.activity_popup6;
        //((PopupActivity)PopupActivity.popupContext).returnPointNum(R.layout.activity_popup6);
        Intent intent = new Intent(PointActivity.this, PopupActivity.class);
        startActivity(intent);
    }
*/
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}
