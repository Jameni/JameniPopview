package com.jameni.jamenipoplib.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.jameni.jamenipoplib.R;

public class RotateUtil {

    private Context context;


    public RotateUtil(Context context) {
        this.context = context;
    }

    public void role_up_to_dwon(View view) {

        Animation up_to_dwon = AnimationUtils.loadAnimation(context, R.anim.jameni_rotate_down);
        up_to_dwon.setFillAfter(true);
        view.startAnimation(up_to_dwon);
    }

    public void role_down_to_up(View view) {

        Animation down_to_up = AnimationUtils.loadAnimation(context, R.anim.jameni_rotate_up);
        down_to_up.setFillAfter(true);
        view.startAnimation(down_to_up);
    }

    public void role_right_to_dwon(View view) {

        Animation right_to_dwon = AnimationUtils.loadAnimation(context, R.anim.jameni_rotate_right_to_down);
        right_to_dwon.setFillAfter(true);
        view.startAnimation(right_to_dwon);
    }

    public void role_down_to_right(View view) {

        Animation down_to_right = AnimationUtils.loadAnimation(context, R.anim.jameni_rotate_down_to_right);
        down_to_right.setFillAfter(true);
        view.startAnimation(down_to_right);
    }

}
