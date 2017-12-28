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

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     * <p>
     * <p>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    public ViewCircleAnimation(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs,0);
        init();
    }

    /**
     * Perform inflation from XML and apply a class-specific base style from a
     * theme attribute. This constructor of View allows subclasses to use their
     * own base style when they are inflating. For example, a Button class's
     * constructor would call this version of the super class constructor and
     * supply <code>R.attr.buttonStyle</code> for <var>defStyleAttr</var>; this
     * allows the theme's button style to modify all of the base view attributes
     * (in particular its background) as well as the Button class's attributes.
     *
     * @param context      The Context the view is running in, through which it can
     *                     access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     *                     reference to a style resource that supplies default values for
     *                     the view. Can be 0 to not look for defaults.
     */
    public ViewCircleAnimation(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * Implement this to do your drawing.
     *
     */
    protected  void init()
    {
        paint  = new Paint();
        paint.setColor(Color.GREEN);
        PropertyValuesHolder  propertyRadius = PropertyValuesHolder.ofInt(PROPERTY_RADIUS,0,150);
        PropertyValuesHolder  propertyRotate = PropertyValuesHolder.ofInt(PROPERTY_ROTATE,0,360);
        // ValueAnimator valueAnimator = ValueAnimator.ofInt(5,150);
        ValueAnimator valueAnimator = new ValueAnimator();
        //valueAnimator.setValues(propertyRadius,propertyRotate);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setInterpolator(new CycleInterpolator(10));
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                radius = (int)animation.getAnimatedValue(PROPERTY_RADIUS);
                rotate = (int)animation.getAnimatedValue(PROPERTY_ROTATE);
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