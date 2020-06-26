package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ModifyInfoActivity extends AppCompatActivity {
    private BackPressCloseHandler backPressCloseHandler;
    private int limit_num = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_info);
        backPressCloseHandler = new BackPressCloseHandler(this);

        // home, mypage button
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);

        EditText pwText = (EditText)findViewById(R.id.EditText_modify_pw);
        pwText.setFilters(new InputFilter[] {filterAlphaNum});

        EditText pwCheckText = (EditText)findViewById(R.id.EditText_modify_pw_check);
        pwCheckText.setFilters(new InputFilter[] {filterAlphaNum});
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MyPageActivity.class);
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

    //개인 정보 수정 버튼 클릭
    public void UpdateOnClick(View view){
        //입력 칸들이 비어있는지 확인
        EditText editText_modify_pw = (EditText)findViewById(R.id.EditText_modify_pw);
        String modify_pw_value = editText_modify_pw.getText().toString();  //pw에 입력된 값을 string으로
        EditText edit_modify_pw_check = (EditText)findViewById(R.id.EditText_modify_pw_check);
        String modify_pw_check_value = edit_modify_pw_check.getText().toString();  // pw 확인 칸에 입력된 값을 string으로

        EditText editText_modify_nickname = (EditText)findViewById(R.id.EditText_modify_nickname);
        String modify_nickname_value = editText_modify_nickname.getText().toString();  //닉네임에 입력된 값을 string으로
        EditText editText_modify_phone = (EditText)findViewById(R.id.EditText_modify_phone);
        String modify_phone_value = editText_modify_phone.getText().toString();  //전화번호에 입력된 값을 string으로


        //아무것도 비어있지 않은 경우
        if(modify_pw_value.length() >= limit_num && modify_pw_check_value.length() >= limit_num
                && modify_nickname_value.length() != 0 && modify_phone_value.length() != 0 && modify_pw_check_value.equals(modify_pw_value)){
            Toast.makeText(ModifyInfoActivity.this,"정보 수정 완료", Toast.LENGTH_LONG).show();
            /*
            파라미터로 디비에 넘길 부분
             */
            //Login 페이지로 이동
            //Mypage 페이지로 이동
            Intent intent = new Intent(this, MyPageActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        }

        // 비밀번호 확인이 다른 경우
        else if(!modify_pw_check_value.equals(modify_pw_value)){
            Toast.makeText(ModifyInfoActivity.this,"비밀번호가 일치하지 않습니다.\n다시 확인해주세요.", Toast.LENGTH_LONG).show();
        }

        // 비밀번호 조건에 맞지 않는 경우
        else if(modify_pw_value.length() < limit_num){
            Toast.makeText(ModifyInfoActivity.this,"비밀번호가 조건을 만족하지 않습니다.\n다시 확인해주세요.", Toast.LENGTH_LONG).show();
        }

        // 입력 안된 칸이 있는 경우
        else{
            Toast.makeText(ModifyInfoActivity.this,"모든 정보를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
    }
    // 영문만 허용 (숫자 포함)
    public InputFilter filterAlphaNum = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps = Pattern.compile("^[a-zA-Z0-9]+$");
            if (!ps.matcher(source).matches()) {
                return "";
            }
            return null;
        }
    };
}
