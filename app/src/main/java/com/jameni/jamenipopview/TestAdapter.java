package com.jameni.jamenipopview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jameni.jamenipoplib.adapter.PopListBaseAdapter;
import com.jameni.jamenipoplib.i.PopItemModel;

public class TestAdapter extends PopListBaseAdapter {
    public TestAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TestAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_test, null);

            holder = new TestAdapter.ViewHolder();
            holder.tvItem = convertView.findViewById(R.id.tvItem);
            convertView.setTag(holder);
        } else {
            holder = (TestAdapter.ViewHolder) convertView.getTag();
        }


        if (getItem(position) instanceof PopItemModel) {
            PopItemModel model = getItem(position);

            holder.tvItem.setText(model.getText() == null ? "" : model.getText());
        }


        return convertView;
    }

    class ViewHolder {
        public TextView tvItem;
    }

}
