package com.ol.olcx.Views;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by GW00070468 on 2017/8/14.
 */

public class MyDrawLayout extends DrawerLayout {
    private float mDownFloat;
    private long mTime;
    private GestureDetector mGestureDetector;
    private boolean isLongPressTime;
    private boolean isFirst;

    public MyDrawLayout(Context context) {
        this(context,null);
    }

    public MyDrawLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyDrawLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mGestureDetector = new GestureDetector(context, mOnGestureListener);
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }
    private GestureDetector.SimpleOnGestureListener mSimpleOnGestureListener=new GestureDetector.SimpleOnGestureListener(){
        @Override
        public void onLongPress(MotionEvent e) {
            super.onLongPress(e);
        }
    };
   private GestureDetector.OnGestureListener mOnGestureListener=new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            return false;
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
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };

//
//    @Override
//    public boolean onTouchEvent(MotionEvent ev) {
//        return true;
//
////        switch (ev.getAction()) {
////            case MotionEvent.ACTION_DOWN:
////                mDownFloat=ev.getX();
////                if (mDownFloat>=0 && mDownFloat<20)
////                    return false;
////             ;
////                mTime=System.currentTimeMillis();
////
////            case MotionEvent.ACTION_MOVE:
////                float v = mDownFloat - ev.getX();
////                if (v<0)
////                    return false;
////            case MotionEvent.ACTION_UP:
////                long currentTimeMillis = System.currentTimeMillis();
////                if ((mTime-currentTimeMillis)>50) {
////                    return false;
////                }
////                float v1 = mDownFloat - ev.getX();
////                if (v1<0)
////                    return false;
////
////        }
////        return super.onTouchEvent(ev);
//    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        float x = ev.getX();
        if (x>=0 && x<25)
            return false;
        return super.dispatchTouchEvent(ev);
    }


}
