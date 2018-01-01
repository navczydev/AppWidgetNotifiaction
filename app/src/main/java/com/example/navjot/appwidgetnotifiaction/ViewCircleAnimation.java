package com.example.navjot.appwidgetnotifiaction;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.Toast;

/**
 * Created by Navjot on 12/28/2017.
 */

class ViewCircleAnimation extends View {
    private Paint paint;
    int radius=0,rotate=0;
    String PROPERTY_RADIUS = "radius";
    String PROPERTY_ROTATE = "rotate";
    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public ViewCircleAnimation(Context context) {
        super(context,null);
        init();

    }
    public ViewCircleAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
        init();
    }
    public ViewCircleAnimation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected  void init()
    {
        paint  = new Paint();
        paint.setColor(Color.GREEN);
        PropertyValuesHolder  propertyRadius = PropertyValuesHolder.ofInt(PROPERTY_RADIUS,0,150);
        PropertyValuesHolder  propertyRotate = PropertyValuesHolder.ofInt(PROPERTY_ROTATE,0,360);
        // ValueAnimator valueAnimator = ValueAnimator.ofInt(5,150);
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setValues(propertyRadius,propertyRotate);
        //valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setInterpolator(new CycleInterpolator(10));
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                radius = (int)animation.getAnimatedValue(PROPERTY_RADIUS);
                rotate = (int)animation.getAnimatedValue(PROPERTY_ROTATE);
                //Toast.makeText(getContext(),"ok",Toast.LENGTH_LONG).show();
                invalidate();
            }
        });
        valueAnimator.start();

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int viewWidth = getWidth()/2;
        int viewHeight = getHeight()/2;
        int leftTopX = viewWidth-150;
        int leftTopY = viewHeight-150;
        int rightBotX = viewWidth+150;
        int rightBotY = viewHeight+150;
        canvas.rotate(rotate,viewWidth,viewHeight);

        canvas.drawRoundRect(leftTopX,leftTopY,rightBotX,rightBotY,radius,radius,paint);

    }
}