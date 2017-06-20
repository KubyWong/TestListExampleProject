package com.example.kubyhuang.mymacpro.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.example.kubyhuang.mymacpro.utils.LogUtils;

/**
 * 自定义弹性的listview
 * Created by kubyhuang on 2017/2/3.
 */
public class TanXingListView extends ListView{
    int mMaxOverScrollY = 200;

    public TanXingListView(Context context) {
        super(context);
    }

    public TanXingListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TanXingListView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        LogUtils.d_log("overScrollBy -- > "+maxOverScrollY);
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverScrollY, isTouchEvent);
    }

}
