package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

//회원가입 페이지
public class SignUpActivity extends AppCompatActivity {

    private Spinner univSpinner;
    private ArrayAdapter univAdapter;
    private Spinner majorSpinner;
    private ArrayAdapter majorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        univSpinner = (Spinner) findViewById(R.id.univ_spinner);
        univAdapter = ArrayAdapter.createFromResource(this, R.array.univ, android.R.layout.simple_spinner_dropdown_item);
        univSpinner.setAdapter(univAdapter);

        //univSpinner의 item 선택
        univSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override  //선택한 item에 따라 다른 parameter 값으로 selectedCollege 함수 출력
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (parent.getSelectedItemPosition()){
                    case 0:
                        selectedMajor(0);  //불교대학
                        break;
                    case 1:
                        selectedMajor(1);  //문과대학
                        break;
                    case 2:
                        selectedMajor(2);  //이과대학
                        break;
                    case 3:
                        selectedMajor(3);  //법과대학
                        break;
                    case 4:
                        selectedMajor(4);  //사회과학대학
                        break;
                    case 5:
                        selectedMajor(5);  //경찰사법대학
                        break;
                    case 6:
                        selectedMajor(6);  //경영대학
                        break;
                    case 7:
                        selectedMajor(7);  //바이오시스템대학
                        break;
                    case 8:
                        selectedMajor(8);  //공과대학
                        break;
                    case 9:
                        selectedMajor(9);  //사범대학
                        break;
                    case 10:
                        selectedMajor(10);  //예술대학
                        break;
                    case 11:
                        selectedMajor(11);  //약학대학
                        break;
                    case 12:
                        selectedMajor(12);  //미래융합대학
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void SignInOnClick(View view){
        //입력 칸들이 비어있는지 확인
        EditText editText_sign_id = (EditText)findViewById(R.id.EditText_sign_id);
        String sign_id_value = editText_sign_id.getText().toString();  //id에 입력된 값을 string으로
        EditText editText_sign_pw = (EditText)findViewById(R.id.EditText_sign_pw);
        String sign_pw_value = editText_sign_pw.getText().toString();  //pw에 입력된 값을 string으로
        EditText editText_name = (EditText)findViewById(R.id.EditText_name);
        String name_value = editText_name.getText().toString();  //이름에 입력된 값을 string으로
        EditText editText_nickname = (EditText)findViewById(R.id.EditText_nickname);
        String nickname_value = editText_nickname.getText().toString();  //닉네임에 입력된 값을 string으로
        EditText editText_phone = (EditText)findViewById(R.id.EditText_phone);
        String phone_value = editText_phone.getText().toString();  //전화번호에 입력된 값을 string으로

        //아무것도 비어있지 않은 경우
        if(sign_id_value.length() != 0 && sign_pw_value.length() != 0 && name_value.length() != 0 && nickname_value.length() != 0 && phone_value.length() != 0){
            Toast.makeText(SignUpActivity.this,"회원가입 성공", Toast.LENGTH_LONG).show();

            //Login 페이지로 이동
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            /*
            1. 아이디 확인 : DB에 있는지
            1-1-1. DB에 있는 아이디면 -> 아이디 사용 불가
            1-1-2. DB에 없는 아이디면 -> 아이디 사용 가능
            2. 비밀번호 재확인 만들기
            3. 전화번호 확인 : DB에 있는지 -> 1인당 1계정
            3-1. 전화번호 문자 인증
            */
        }

        //아이디가 비어있는 경우
        else if(sign_id_value.length() == 0){
            Toast.makeText(SignUpActivity.this,"아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
        //비밀번호가 비어있는 경우
        else if(sign_pw_value.length() == 0) {
            Toast.makeText(SignUpActivity.this,"비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
        //이름이 비어있는 경우
        else if(name_value.length() == 0){
            Toast.makeText(SignUpActivity.this,"이름을 입력해주세요.", Toast.LENGTH_LONG).show();
        }
        //닉네임이 비어있는 경우
        else if(nickname_value.length() == 0){
            Toast.makeText(SignUpActivity.this,"닉네임을 입력해주세요.", Toast.LENGTH_LONG).show();
        }
        //전화번호가 비어있는 경우
        else if(phone_value.length() == 0){
            Toast.makeText(SignUpActivity.this,"전화번호를 입력해주세요.", Toast.LENGTH_LONG).show();
        }
    }


    private void selectedMajor(int univ_num){
        switch(univ_num){  //선택한 univSpinner에 따라
            case 0:  //불교대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.buddhist, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 1:  //문과대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.literature, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 2:  //이과대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.science, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 3:  //법과대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this,  R.array.law, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 4:  //사회과학대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.social, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 5:  //경찰사법대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.police, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 6:  //경영대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.business, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 7:  //바이오시스템대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.bio, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 8:  //공과대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.engineering, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 9:  //사범대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.education, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 10:  //예술대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.arts, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 11:  //약학대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.pharmacy, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
            case 12:  //미래융합대학
                majorSpinner = (Spinner) findViewById(R.id.major_spinner);
                majorAdapter = ArrayAdapter.createFromResource(this, R.array.future, android.R.layout.simple_spinner_dropdown_item);
                majorSpinner.setAdapter(majorAdapter);
                break;
        }
    }
}
