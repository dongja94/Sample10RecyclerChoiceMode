package com.example.dongja94.samplerecyclerchoicemode;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class ItemView extends FrameLayout implements Checkable {
    public ItemView(Context context) {
        super(context);
        init();
    }

    TextView titleView;
    ImageView checkView;
    private void init() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        inflate(getContext(), R.layout.view_item, this);
        titleView = (TextView)findViewById(R.id.text_title);
        checkView = (ImageView)findViewById(R.id.image_check);
    }

    public void setTitlte(String title) {
        titleView.setText(title);
    }

    private void drawCheck() {
        if (isChecked) {
            checkView.setImageResource(android.R.drawable.checkbox_on_background);
        } else {
            checkView.setImageResource(android.R.drawable.checkbox_off_background);
        }
    }

    boolean isChecked = false;
    @Override
    public void setChecked(boolean checked) {
        if (isChecked != checked) {
            isChecked = checked;
            drawCheck();
        }
    }

    @Override
    public boolean isChecked() {
        return isChecked;
    }

    @Override
    public void toggle() {
        setChecked(!isChecked);
    }
}
