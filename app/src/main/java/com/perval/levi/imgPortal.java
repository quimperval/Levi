package com.perval.levi;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.Toast;

public class imgPortal extends AppCompatActivity {


    ImageView mimageView;

    int mTop, mLeft, mWidth, mHeight;
    int Xc, Yc;

    int mImageWidth, mImageHeight;

    float scaleX0, scaleY0;
    private int[] locationIm = new int[2];

    @Override
    public void onCreate(@Nullable Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_img_portal);

        Bundle bundle = getIntent().getExtras();

        mimageView = findViewById(R.id.imageViewPortalActivity);

        mTop = bundle.getInt(Utils.PACK+Utils.mTop);
        mLeft = bundle.getInt(Utils.PACK+Utils.mLeft);
        mWidth = bundle.getInt(Utils.PACK+Utils.mWidth);
        mHeight = bundle.getInt(Utils.PACK+Utils.mHeight);



        //Toast.makeText(this, "mTop: " + mTop + " mLeft: "+ mLeft + " mWidth: "+ mWidth + " mHeight: "+mHeight, Toast.LENGTH_SHORT).show();

        if(saveInstanceState==null){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                ObjectAnimator moveX2Center, moveY2Center, animScaleX,animScaleY;

                ViewTreeObserver observer = mimageView.getViewTreeObserver();
                observer.addOnPreDrawListener(
                        new ViewTreeObserver.OnPreDrawListener() {
                            @Override
                            public boolean onPreDraw() {
                                mimageView.getViewTreeObserver().removeOnPreDrawListener(this);
                                mImageHeight = mimageView.getHeight();
                                mImageWidth = mimageView.getWidth();


                                mimageView.getLocationOnScreen(locationIm);
                                scaleX0 = (float) mWidth/mImageWidth;
                                scaleY0 = (float) mHeight/mImageHeight;

                                Rect myRect = new Rect();
                                mimageView.getGlobalVisibleRect(myRect);
                                mimageView.setPivotX(mLeft);
                                mimageView.setPivotY(mTop);

                                //Toast.makeText(getBaseContext(), "/////////////IMG PORTAL//////////////", Toast.LENGTH_SHORT).show();

                                //Toast.makeText(getBaseContext(), "RectTop: " + myRect.top + " RectLeft: "+ myRect.left , Toast.LENGTH_SHORT).show();

                                //Toast.makeText(getBaseContext(), "screenLoc[0]: " + locationIm[0]+"screenLoc[1]: " + locationIm[1], Toast.LENGTH_SHORT).show();

                                Xc = locationIm[0]+mImageWidth/2;
                                Yc = locationIm[1]+mImageHeight/2;

                                int deltaX1, deltaX2;
                                int deltaY1, deltaY2;

                                deltaX1= -(mLeft-locationIm[0]);
                                deltaX2= locationIm[0];


                                deltaY1 = -(mTop-locationIm[1]);
                                deltaY2 = locationIm[1];

                                //mimageView.setTranslationX(deltaX1);
                                //mimageView.setTranslationY(deltaY1);


                                ObjectAnimator moveX2Center, moveY2Center, animScaleX, animScaleY, alphaanim;
                                moveX2Center = ObjectAnimator.ofFloat(
                                        mimageView, "translationX", 0);
                                moveY2Center = ObjectAnimator.ofFloat(
                                        mimageView, "translationY", 0);



                                //Toast.makeText(getBaseContext(), "screenLoc[0]: " + locationIm[0]+"screenLoc[1]: " + locationIm[1], Toast.LENGTH_SHORT).show();
                                //Toast.makeText(getBaseContext(), "mLeft: " + mLeft + " mTop: "+ mTop , Toast.LENGTH_SHORT).show();

                                animScaleX = ObjectAnimator.ofFloat(mimageView, "scaleX", scaleX0, 1);
                                animScaleY = ObjectAnimator.ofFloat(mimageView, "scaleY", scaleY0, 1);

                                alphaanim = ObjectAnimator.ofFloat(mimageView, "alpha", 0, 1);


                                AnimatorSet ASmove2Center = new AnimatorSet();

                                //ASmove2Center.playTogether(moveX2Center, moveY2Center, animScaleX, animScaleY);
                                ASmove2Center.playTogether(alphaanim);
                                ASmove2Center.setDuration(800);
                                ASmove2Center.start();


                                return true;
                            }
                        });



            }

        }









    }





}
