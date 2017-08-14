package com.ol.olcx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

public class UserProfileActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private View mCloseView;
    private boolean onlyOneTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        mLayout = (LinearLayout) findViewById(R.id.user_profile_layout);
        mCloseView = (View) findViewById(R.id.user_profile_close);

        ViewCompat.animate(mLayout).alpha(0);
        mCloseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!onlyOneTime) {
                    ViewCompat.setTranslationX(mLayout,- mLayout.getMeasuredWidth());
                    ViewPropertyAnimatorCompat animate = ViewCompat.animate(mLayout);
                    animate.translationX(0).alpha(1).setDuration(300).start();
                    onlyOneTime=!onlyOneTime;
                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
