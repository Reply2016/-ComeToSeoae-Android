package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//로그인 페이지
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //로그인 버튼 클릭
    public void LoginOnClick(View view){
        //아이디, 비밀번호 입력 칸이 비어있는지 확인
        EditText editText_id = (EditText)findViewById(R.id.EditText_id);
        String id_value = editText_id.getText().toString();  //id에 입력된 값을 string으로
        EditText editText_pw = (EditText)findViewById(R.id.EditText_pw);
        String pw_value = editText_pw.getText().toString();  //pw에 입력된 값을 string으로

        //아이디, 비밀번호 둘 다 비어있지 않은 경우
        if(id_value.length() != 0 && pw_value.length() != 0){
            Toast.makeText(LoginActivity.this,"로그인 성공", Toast.LENGTH_LONG).show();

            //Main 페이지로 이동
            Intent intent = new Intent(this, MainPageActivity.class);
            startActivity(intent);
            /*
            1. 아이디 확인 : DB에 있는지
            2-1. DB에 있는 아이디면 -> 비밀번호가 맞는지 확인
                2-1-1. 비밀번호가 맞으면 -> 로그인 성공 -> 메인화면으로
                2-1-2. 비밀번호가 틀리면 -> "잘못된 비밀번호입니다. 다시 입력해주세요"
            2-2. DB에 없는 아이디면 -> "없는 아이디입니다. 다시 입력해주세요" or "없는 아이디입니다. 회원가입해주세요"
             */
        }
        //아이디가 비어있는 경우
        else if(id_value.length() == 0){
            Toast.makeText(LoginActivity.this,"아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
        //비밀번호가 비어있는 경우
        else if(pw_value.length() == 0) {
            Toast.makeText(LoginActivity.this,"비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
    }

    //회원가입 버튼 클릭
    public void SignUpOnClick(View view){
        //SignUp 페이지로 이동
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
