package com.example.android.exampleprototype;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class PopupActivity4 extends AppCompatActivity {
    //public static Context popupContext;
    Button okBtn, closeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        okBtn = (Button) findViewById(R.id.okBtn);
        closeBtn = (Button) findViewById(R.id.closeBtn);

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_popup4);

    }

    // 확인 버튼 클릭 - 팝업창 ok 버튼 이벤트
    public void popupOk(View view){
        finish();
        /*
        Intent intent = new Intent(this, PointActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        */
    }  // 데이터 전달 - 포인트 차감

    // 취소 버튼 클릭 - 팝업창 cancel 버튼 이벤트
    public void popupClose(View view){
        finish();
    }  // 데이터 전달 X - 포인트 그대로

    public boolean onTouchEvent(MotionEvent event){
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        return;
    }  // back 버튼 사용 불가
}