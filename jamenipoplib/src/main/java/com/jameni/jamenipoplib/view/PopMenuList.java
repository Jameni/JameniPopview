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
 * 菜单列表
 */
public class PopMenuList extends PopupWindow implements OnItemClickListener, View.OnClickListener {
    private Context context;
    private View layoutView;
    private RelativeLayout popJameniLayout;
    private ListView lvPop;
    private List dataList;

    private PopListBaseAdapter adapter;
    private PopItemClickListener listener;
    private int tag;
    private boolean isDismiss = true;//是否已经关闭


    //    private Animation mAlphaOpenAnimation;
//    private Animation mAlphaCloseAnimation;
    private Animation mPopOpenAnimation;
    private Animation mPopCloseAnimation;

    public PopMenuList(Context context, List datas, PopItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        this.dataList = datas;
        initListData();
        findView();

    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public void setT(PopListBaseAdapter t) {
        adapter = t;
    }

    public PopMenuList(Context context, PopListBaseAdapter adapter, PopItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        setT(adapter);
        initListData();
        findView();

    }


    // 初始化列表数据
    public void initListData() {

    }

    private void findView() {

        layoutView = LayoutInflater.from(context).inflate(R.layout.view_pop_list, null);
        lvPop = layoutView.findViewById(R.id.lvPopList);
        popJameniLayout = layoutView.findViewById(R.id.popJameniLayout);
        popJameniLayout.setOnClickListener(this);

        if (adapter == null) {
            adapter = new PopItemAdapter(context);
            adapter.update(dataList);
        }
        lvPop.setAdapter(adapter);
        lvPop.setOnItemClickListener(this);

//
        setContentView(layoutView);

        initAnim();
        this.setFocusable(true);
        setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.JameniPop);
    }


    private void initAnim() {
        mPopOpenAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0);
        mPopOpenAnimation.setDuration(300);
        mPopCloseAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
        mPopCloseAnimation.setDuration(300);
        mPopCloseAnimation.setFillAfter(true);

        //动画监听
        //展示动画监听
        mPopOpenAnimation.setAnimationListener(new PopAnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //动画开始
                isDismiss = false;
            }
        });
        //关闭动画监听
        mPopCloseAnimation.setAnimationListener(new PopAnimationListener() {

            @Override
            public void onAnimationEnd(Animation animation) {

                if (layoutView != null) {
                    //关闭窗口
                    layoutView.post(dismissRunnable);
                }
            }
        });
    }


    private Runnable dismissRunnable = new Runnable() {
        @Override
        public void run() {
            PopMenuList.super.dismiss();//这里一定要调用父类的dismiss ，不然会重复调用子类
        }
    };


    public void show(View view) {

        if (isDismiss) {
            if (Build.VERSION.SDK_INT < 24) {
                showAsDropDown(view);
            } else {
                Rect visibleFrame = new Rect();
                view.getGlobalVisibleRect(visibleFrame);
                int height = view.getResources().getDisplayMetrics().heightPixels - visibleFrame.bottom;
                setHeight(height);
                showAsDropDown(view, 0, 0);
            }

            isDismiss = false;

            if (view != null) {
                layoutView.startAnimation(mPopOpenAnimation);
            }
        }


    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (listener != null) {
            listener.popItemClick(adapter.getItem(position), position, tag);
        }
        dismiss();

    }


    @Override
    public void onClick(View view) {
        dismiss();
    }

    @Override
    public void dismiss() {
//        super.dismiss();
        if (!isDismiss && layoutView != null) {
            isDismiss = true;
            layoutView.startAnimation(mPopCloseAnimation);
        }
    }
}
