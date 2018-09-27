package com.jameni.jamenipoplib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jameni.jamenipoplib.R;
import com.jameni.jamenipoplib.i.PopItemModel;

public class PopItemAdapter extends PopListBaseAdapter {


    public PopItemAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_pop_txt, null);

            holder = new ViewHolder();
            holder.tv = convertView.findViewById(R.id.tv);
            holder.rlPopItem = convertView.findViewById(R.id.rlPopItem);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        if (getItem(position) instanceof PopItemModel) {
            PopItemModel model = getItem(position);

            holder.tv.setText(model.getText() == null ? "" : model.getText());
            if (model.getTextSize() > 0) {
                holder.tv.setTextSize(model.getTextSize());
            }

            if (model.getTextColorResId() > 0) {
                holder.tv.setTextColor(mContext.getResources().getColor(model.getTextColorResId()));
            }

            if (model.getBackgroundColorResId() > 0) {
                holder.rlPopItem.setBackgroundResource(model.getBackgroundColorResId());
            }
        }


        return convertView;
    }

    class ViewHolder {
        public TextView tv;
        public RelativeLayout rlPopItem;
    }


}
