package org.techtown.event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
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
        View view = findViewById(R.id.view); // 화면에 있는 view(1) 불러오기

        view.setOnTouchListener(new View.OnTouchListener() { // view에 발생하는 touch 이벤트를 감지하는 함수
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

        /**
         *  GestureDetector
         */
        GestureDetector detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) { // 클릭했을 시
                println("onDown 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) { // 오래 눌렸을 시
                println("onLongPress 호출됨");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) { // 누른채로 움직였을 시
                println("onFling 호출됨 : " + velocityX + ", " + velocityY);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2); // 화면에 있는 view2 불러오기
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });
    }

    /**
     * key 이벤트
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //key가 눌렸을 때 자동으로 호출됨
        if (keyCode == KeyEvent.KEYCODE_BACK){
            println("시스템 [BACK]버튼이 눌렸습니다.");
            return true;
        }
        return false;
    }

    public void println(String data){ // textView에 출력하는 함수
        textView.append(data + "\n");
    }

}