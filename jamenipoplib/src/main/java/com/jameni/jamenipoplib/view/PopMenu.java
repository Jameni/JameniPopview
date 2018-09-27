package com.jameni.jamenipoplib.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.jameni.jamenipoplib.R;
import com.jameni.jamenipoplib.adapter.PopItemAdapter;
import com.jameni.jamenipoplib.adapter.PopListBaseAdapter;
import com.jameni.jamenipoplib.i.PopAnimationListener;
import com.jameni.jamenipoplib.i.PopItemClickListener;

import java.util.List;

/**
 * 菜单
 */
public class PopMenu extends PopupWindow {
    private Context context;
    private View layoutView, costomView;
    private LinearLayout costomLayout;

    private int tag;


    public PopMenu(Context context, View costomView) {
        this.context = context;
        this.costomView = costomView;
        findView();

    }

    public void setTag(int tag) {
        this.tag = tag;
    }


    private void findView() {

        layoutView = LayoutInflater.from(context).inflate(R.layout.view_pop_costom, null);
        costomLayout = layoutView.findViewById(R.id.popJameniCostomLayout);

        if (costomView != null) {
            costomLayout.addView(costomView);
        }
        setContentView(layoutView);

        this.setFocusable(true);
        setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.JameniPop);
    }


    public void show(View view) {

        if (Build.VERSION.SDK_INT < 24) {
            showAsDropDown(view);
        } else {
            Rect visibleFrame = new Rect();
            view.getGlobalVisibleRect(visibleFrame);
            int height = view.getResources().getDisplayMetrics().heightPixels - visibleFrame.bottom;
            setHeight(height);
            showAsDropDown(view, 0, 0);
        }

    }


}
