package org.techtown.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView); // 화면에 있는 textView(3) 불러오기
        View view = findViewById(R.id.view); //화면에 있는 view(1) 불러오기

        view.setOnTouchListener(new View.OnTouchListener() { //view에 발생하는 touch 이벤트를 감지하는 함수
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int action = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if(action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림: " + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_MOVE){
                    println("손가락 움직임: " + curX + ", " + curY);
                } else if(action == MotionEvent.ACTION_UP){
                    println("손가락 땜: " + curX + ", " + curY);
                }

                return true;
            }
        });
    }

    public void println(String data){ //출력하는 함수
        textView.append(data + "\n");
    }

}