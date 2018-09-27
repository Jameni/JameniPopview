package com.jameni.jamenipopview;

import com.jameni.jamenipoplib.i.PopItemModel;

public class ItemData implements PopItemModel {

    private int textColorResId;
    private int backgroundColorResId;
    private String text;
    private float textSize;


    public ItemData(String text) {
        this.text = text;
    }

    public ItemData(int textColorResId, String text) {
        this.textColorResId = textColorResId;
        this.text = text;
    }

    public ItemData(int textColorResId, int backgroundColorResId, String text) {
        this.textColorResId = textColorResId;
        this.backgroundColorResId = backgroundColorResId;
        this.text = text;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public void setTextColorResId(int textColorResId) {
        this.textColorResId = textColorResId;
    }


    public void setBackgroundColorResId(int backgroundColorResId) {
        this.backgroundColorResId = backgroundColorResId;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public float getTextSize() {
        return textSize;
    }

    @Override
    public int getTextColorResId() {
        return textColorResId;
    }

    @Override
    public int getBackgroundColorResId() {
        return backgroundColorResId;
    }
}
