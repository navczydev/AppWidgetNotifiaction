package com.example.navjot.appwidgetnotifiaction;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
TextView textView;
int value =0 ;
String PROPERTY_RADIUS = "radius";
//    ViewCircleAnimation viewCircleAnimation = new ViewCircleAnimation(this);
            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // textView = findViewById(R.id.textView);
       // ViewCircleAnimation viewCircleAnimation  = new ViewCircleAnimation(this);
       // PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofInt(PROPERTY_RADIUS,0,50);
       // ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100);
       // ValueAnimator valueAnimator  = new ValueAnimator();
       // valueAnimator.setDuration(10000);
       // valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
         //   @Override
          //  public void onAnimationUpdate(ValueAnimator animation) {
           //      value = (int)animation.getAnimatedValue();
          //      viewCircleAnimation.radius= (int)animation.getAnimatedValue(PROPERTY_RADIUS);
              //  textView.setText("New animated value is "+value);
             //   viewCircleAnimation.invalidate();
              //  Log.d(getPackageName(),value+"");
          //  }
        //});
       // valueAnimator.start();


    }

}



