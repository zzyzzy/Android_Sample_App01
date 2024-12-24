package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // xml에 정의한 뷰에 대한 변수 선언
    private EditText editText;
    private EditText editTextPasswd;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        // activity_main.xml 내용을 앱 메인에 표시
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // xml에 정의한 뷰를 찾아서 변수에 등록
        editText = findViewById(R.id.editTextText);
        editTextPasswd = findViewById(R.id.editTextTextPassword);
        button = findViewById(R.id.button);

        // 버튼에 클릭 이벤트 설정
        button.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 아이디/비밀번호 텍스트 읽어오기
                    String userid = editText.getText().toString();
                    String passwd = editTextPasswd.getText().toString();

                    // 읽어온 텍스트를 토스트 메세지로 표시
                    String msg = userid + "/" + passwd;
                    Toast.makeText(MainActivity.this, msg,
                        Toast.LENGTH_SHORT).show();
                }
            }
        );
    }
}