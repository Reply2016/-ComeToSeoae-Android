package com.example.android.exampleprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Pattern;

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

        EditText idText = (EditText)findViewById(R.id.EditText_sign_id);
        idText.setFilters(new InputFilter[] {filterAlphaNum});
        String idString = idText.getText().toString();

        EditText pwText = (EditText)findViewById(R.id.EditText_sign_pw);
        pwText.setFilters(new InputFilter[] {filterAlphaNum});

        EditText pwCheckText = (EditText)findViewById(R.id.EditText_sign_pw_check);
        pwCheckText.setFilters(new InputFilter[] {filterAlphaNum});

        EditText nameText = (EditText)findViewById(R.id.EditText_name);
        nameText.setFilters(new InputFilter[] {filterKor});

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

    public void IDCheckOnClick(View view){
        EditText idText = (EditText)findViewById(R.id.EditText_sign_id);
        String idString = idText.getText().toString();

        if(idString.length() < 4){
            Toast.makeText(SignUpActivity.this,"최소 4글자 이상이여야 합니다.", Toast.LENGTH_LONG).show();
        }
        else if(idString.length() >= 4){
            // DB랑 연결해서 존재하는 아이디인지 확인
            Toast.makeText(SignUpActivity.this,"사용할 수 있는 아이디입니다.", Toast.LENGTH_LONG).show();
            /*
            DB 연결로 파라미터 넘겨서 확인해야 함
            if문으로 사용할 수 있는 아이디면 -> "사용할 수 있는 아이디입니다."
            이미 있는 아이디면 -> "사용할 수 없는 아이디입니다."
            */
        }
    }

    public void SignInOnClick(View view){
        //입력 칸들이 비어있는지 확인
        EditText editText_sign_id = (EditText)findViewById(R.id.EditText_sign_id);
        String sign_id_value = editText_sign_id.getText().toString();  //id에 입력된 값을 string으로
        EditText editText_sign_pw = (EditText)findViewById(R.id.EditText_sign_pw);
        String sign_pw_value = editText_sign_pw.getText().toString();  //pw에 입력된 값을 string으로
        EditText edit_pw_check = (EditText)findViewById(R.id.EditText_sign_pw_check);
        String pw_check_value = edit_pw_check.getText().toString();  // pw 확인 칸에 입력된 값을 string으로
        EditText editText_name = (EditText)findViewById(R.id.EditText_name);
        String name_value = editText_name.getText().toString();  //이름에 입력된 값을 string으로
        EditText editText_nickname = (EditText)findViewById(R.id.EditText_nickname);
        String nickname_value = editText_nickname.getText().toString();  //닉네임에 입력된 값을 string으로
        EditText editText_phone = (EditText)findViewById(R.id.EditText_phone);
        String phone_value = editText_phone.getText().toString();  //전화번호에 입력된 값을 string으로


        //아무것도 비어있지 않은 경우
        if(sign_id_value.length() != 0 && sign_pw_value.length() != 0 && pw_check_value.length() != 0 && name_value.length() != 0
                && nickname_value.length() != 0 && phone_value.length() != 0 && pw_check_value.equals(sign_pw_value)){
            Toast.makeText(SignUpActivity.this,"회원가입 성공", Toast.LENGTH_LONG).show();
            /*
            파라미터로 디비에 넘길 부분
             */
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

        // 비밀번호 확인이 다른 경우
        else if(!pw_check_value.equals(sign_pw_value)){
            Toast.makeText(SignUpActivity.this,"비밀번호가 일치하지 않습니다.\n다시 확인해주세요.", Toast.LENGTH_LONG).show();
        }

        // 입력 안된 칸이 있는 경우
        else{
            Toast.makeText(SignUpActivity.this,"모든 정보를 입력해주세요.", Toast.LENGTH_LONG).show();
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

    // 한글만 허용
    public InputFilter filterKor = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps = Pattern.compile("^[ㄱ-ㅣ가-힣]+$");
            if (!ps.matcher(source).matches()) {
                return "";
            }
            return null;
        }
    };
}
