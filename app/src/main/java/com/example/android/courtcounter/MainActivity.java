package com.example.android.courtcounter;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    String countDownTimer;
    long millisUntilFinishedInt = 5000;
    long milliseconds;
    long seconds;
    long totalAddedTime = 0;
    TextView text1;

    MyCount counter = new MyCount(millisUntilFinishedInt + totalAddedTime,17);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(TextView)findViewById(R.id.team_a_score);
        counter.start();
    }

    public class MyCount extends CountDownTimer {

        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            millisUntilFinishedInt = millisUntilFinished;
            seconds = millisUntilFinishedInt/1000;
            milliseconds = millisUntilFinishedInt-(millisUntilFinishedInt/1000)*1000;
            countDownTimer = "TIME: " + seconds + "." + milliseconds ;
           text1.setText(countDownTimer);
        }

        @Override
        public void onFinish() {
            countDownTimer = "TIME'S UP!";
            text1.setText(countDownTimer);
        }
    }

    public void timerCreation (){
        counter.cancel();
        counter = new MyCount(millisUntilFinishedInt + 5000,1);
        counter.start();
    }

    public void threePoints (View v) {
        counter.cancel();
        timerCreation();
    }
}
