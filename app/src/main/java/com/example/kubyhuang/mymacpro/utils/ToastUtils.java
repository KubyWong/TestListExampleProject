package com.example.kubyhuang.mymacpro.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by kubyhuang on 2017/2/3.
 */

public class ToastUtils {
    public static void showT(Context context,String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
