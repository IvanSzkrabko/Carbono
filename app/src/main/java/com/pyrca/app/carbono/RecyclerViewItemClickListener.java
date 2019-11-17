package com.pyrca.app.carbono;

import android.view.View;

public abstract class RecyclerViewItemClickListener {
    abstract void onItemClick(View view, int position);
    abstract void onItemLongClick(View view, int position);
}
