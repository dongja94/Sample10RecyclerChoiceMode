package com.example.dongja94.samplerecyclerchoicemode;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Checkable;

/**
 * Created by dongja94 on 2016-01-19.
 */
public class CheckViewHolder extends RecyclerView.ViewHolder {
    View itemView;
    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }
    OnItemClickListener mItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        mItemClickListener = listener;
    }

    public CheckViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, getAdapterPosition());
                }
            }
        });
    }

    public void setTitle(String title) {
        if (itemView instanceof ItemView) {
            ((ItemView)itemView).setTitlte(title);
        }
    }

    public void setChecked(boolean checked) {
        if (itemView instanceof Checkable) {
            ((Checkable)itemView).setChecked(checked);
        }
    }

}
