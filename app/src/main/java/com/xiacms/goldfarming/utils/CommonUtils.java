package com.xiacms.goldfarming.utils;

import android.content.Context;
import android.widget.Toast;

import com.xiacms.goldfarming.global.GoldApplication;

public class CommonUtils {
    private static Toast toast;

    public static void showLongToast(String msg){
        showToast(GoldApplication.getInstance(),msg,Toast.LENGTH_LONG).show();
//        Toast.makeText(FuLiCenterApplication.getInstance(),msg,Toast.LENGTH_LONG).show();
    }
    public static void showShortToast(String msg){
        showToast(GoldApplication.getInstance(),msg,Toast.LENGTH_SHORT).show();
//        Toast.makeText(FuLiCenterApplication.getInstance(),msg,Toast.LENGTH_SHORT).show();
    }
    public static void showLongToast(int rId){
        showLongToast(GoldApplication.getInstance().getString(rId));
    }
    public static void showShortToast(int rId){
        showShortToast(GoldApplication.getInstance().getString(rId));
    }

    public static Toast showToast(Context context,String msg,int length){
        if (toast==null){
            toast = Toast.makeText(context,msg,length);
        }else{
            toast.setText(msg);
        }
        return toast;
    }
}
