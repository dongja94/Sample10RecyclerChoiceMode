package com.example.dongja94.samplerecyclerchoicemode;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class CheckAdapter extends RecyclerView.Adapter<CheckViewHolder> implements CheckViewHolder.OnItemClickListener{
    SparseBooleanArray checkedItems = new SparseBooleanArray();
    int mCheckedPosition = INVALID_POSITION;
    int checkMode;

    public static final int INVALID_POSITION = -1;
    public static final int MODE_SINGLE = 0;
    public static final int MODE_MULTIPLE = 1;
    List<String> items = new ArrayList<String>();

    public void add(String item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position) {
        if (checkMode == MODE_SINGLE) {
            if (mCheckedPosition != position) {
                mCheckedPosition = position;
                notifyDataSetChanged();
            }
        } else if (checkMode == MODE_MULTIPLE) {
            boolean oldChecked = checkedItems.get(position);
            checkedItems.put(position, !oldChecked);
            notifyDataSetChanged();
        }
    }

    public void setItemCheck(int position, boolean checked) {
        if (checkMode == MODE_SINGLE) {
            if (mCheckedPosition != position && checked) {
                mCheckedPosition = position;
                notifyDataSetChanged();
            } else if (mCheckedPosition == position && !checked) {
                mCheckedPosition = INVALID_POSITION;
                notifyDataSetChanged();
            }
        } else if (checkMode == MODE_MULTIPLE) {
            checkedItems.put(position, checked);
            notifyDataSetChanged();
        }
    }

    public int getCheckItemPosition() {
        if (checkMode == MODE_SINGLE) {
            return mCheckedPosition;
        } else {
            return INVALID_POSITION;
        }
    }

    public SparseBooleanArray getCheckedItemPositions() {
        return checkedItems;
    }

    @Override
    public CheckViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CheckViewHolder holder = new CheckViewHolder(new ItemView(parent.getContext()));
        holder.setOnItemClickListener(this);
        return holder;
    }

    public void setMode(int mode) {
        if (mode == MODE_SINGLE || mode == MODE_MULTIPLE) {
            checkMode = mode;
        } else {
            throw new IllegalArgumentException("invalid check mode");
        }
    }

    public int getMode() {
        return checkMode;
    }

    @Override
    public void onBindViewHolder(CheckViewHolder holder, int position) {
        holder.setTitle(items.get(position));
        if (checkMode == MODE_SINGLE) {
            if (position == mCheckedPosition) {
                holder.setChecked(true);
            } else {
                holder.setChecked(false);
            }
        } else if (checkMode == MODE_MULTIPLE) {
            holder.setChecked(checkedItems.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
