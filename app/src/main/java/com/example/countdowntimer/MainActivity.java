package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int[] mArrayImages = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,

    };
    ImageView mImgBanner;
    Button mBtnStart;
    int mcount =0;
    boolean mIsloading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnStart = findViewById(R.id.ButtonStart);
        mImgBanner = findViewById(R.id.imageviewBanner);

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsloading) {
                    return;
                } else
                    mIsloading = true; {
                    CountDownTimer countDownTimer = new CountDownTimer((mArrayImages.length * 1000)+1000, 1000) {
                        @Override
                        public void onTick(long millisUnitFinished) {
                            if (mcount >=mArrayImages.length) {
                                mcount=0;
                            }
                            mImgBanner.setImageResource(mArrayImages[mcount++]);
                        }
                        @Override
                        public void onFinish() {
                                mcount =0;
                                this.start();
                        }
                    };
                    countDownTimer.start();
                }
            }
        });
    }
}
