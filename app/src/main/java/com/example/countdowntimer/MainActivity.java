package com.example.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    int[] mArrayImages = {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,

    };
    ViewFlipper mViewFlipper;
    Button mBtnStart;
    Button mBtnStop;
    boolean mIsloading = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtnStart = findViewById(R.id.ButtonStart);
        mBtnStop = findViewById(R.id.ButtonStop);
        mViewFlipper = findViewById(R.id.viewFlipper);

        for (int i=0;i<mArrayImages.length;i++)
        {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mArrayImages[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mViewFlipper.addView(imageView);
        }

        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mViewFlipper.isFlipping()){
                    return;
                }
                mViewFlipper.setFlipInterval(500);
                mViewFlipper.startFlipping();
            };
        });

        mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewFlipper.stopFlipping();

            }
        });

//        mBtnStart = findViewById(R.id.ButtonStart);
//        mImgBanner = findViewById(R.id.imageviewBanner);
//
//        mBtnStart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mIsloading) {
//                    return;
//                } else
//                    mIsloading = true; {
//                    CountDownTimer countDownTimer = new CountDownTimer((mArrayImages.length * 1000)+1000, 1000) {
//                        @Override
//                        public void onTick(long millisUnitFinished) {
//                            if (mcount >=mArrayImages.length) {
//                                mcount=0;
//                            }
//                            mImgBanner.setImageResource(mArrayImages[mcount++]);
//                        }
//                        @Override
//                        public void onFinish() {
//                                mcount =0;
//                                this.start();
//                        }
//                    };
//                    countDownTimer.start();
//                }
//            }
//        });


    }
}
