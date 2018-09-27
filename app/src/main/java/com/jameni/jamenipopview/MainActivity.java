package com.jameni.jamenipopview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jameni.jamenipoplib.i.PopItemClickListener;
import com.jameni.jamenipoplib.util.RotateUtil;
import com.jameni.jamenipoplib.view.PopMenu;
import com.jameni.jamenipoplib.view.PopMenuList;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_test)
public class MainActivity extends AppCompatActivity implements PopItemClickListener {


    private PopMenuList pop;
    private PopMenu popCostom;
    private List<ItemData> dataList;
    private TestAdapter adapter;
    private RotateUtil rotateUtil;

    private TextView tv, tv4;
    private ImageView img, img2;

    private CostomView costomView;


    @AfterViews
    void initpage() {
        tv = findViewById(R.id.tv);
        tv4 = findViewById(R.id.tv4);
        img = findViewById(R.id.img);
        img2 = findViewById(R.id.img2);
        rotateUtil = new RotateUtil(this);

        costomView = CostomView_.build(this);

    }

    public void tv1(View view) {

        if (pop == null) {

            dataList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                dataList.add(new ItemData(i + ""));
            }
//            pop = new PopMenuList(this, dataList, this);


            adapter = new TestAdapter(this);
            adapter.update(dataList);

            pop = new PopMenuList(this, adapter, this);
        }
        pop.show(tv);
    }

    @Override
    public void popItemClick(Object obj, int position, int flag) {

    }


    boolean index, index2 = true;

    public void tv2(View view) {

        if (index) {

            rotateUtil.role_up_to_dwon(img);
            index = false;
        } else {
            rotateUtil.role_down_to_up(img);
            index = true;
        }

    }


    public void tv3(View view) {

        if (index2) {
            rotateUtil.role_right_to_dwon(img2);
            index2 = false;
        } else {
            rotateUtil.role_down_to_right(img2);
            index2 = true;
        }


    }

    public void tv4(View view) {

        if (popCostom == null) {
            popCostom = new PopMenu(this, costomView);
        }

        popCostom.show(tv4);

    }

}
