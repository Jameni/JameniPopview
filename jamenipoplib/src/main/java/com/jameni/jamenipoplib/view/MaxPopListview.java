package com.jameni.jamenipoplib.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ListView;

import java.util.List;

public class MaxPopListview extends ListView {

    private Context mContext;
    private float heightScale; //跟屏幕的百分比  值是0~1


    public MaxPopListview(Context context) {
        super(context);
        init(context);
    }

    public MaxPopListview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MaxPopListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    public void init(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (1 > heightScale && heightScale > 0) {
            try {
                //最大高度显示为屏幕内容高度的一半
                Display display = ((Activity) mContext).getWindowManager().getDefaultDisplay();
                DisplayMetrics d = new DisplayMetrics();
                display.getMetrics(d);
                //此处是关键，设置控件高度不能超过屏幕高度一半（d.heightPixels / 2）（在此替换成自己需要的高度）
//                heightMeasureSpec = MeasureSpec.makeMeasureSpec(d.heightPixels / 2, MeasureSpec.AT_MOST);
                heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (d.heightPixels * heightScale), MeasureSpec.AT_MOST);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    public void setHeightScale(float heightScale) {
        this.heightScale = heightScale;
    }
}
