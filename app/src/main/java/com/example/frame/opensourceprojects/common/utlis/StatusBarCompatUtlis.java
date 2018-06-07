package com.example.frame.opensourceprojects.common.utlis;
/*
 *           .--,       .--,
 *          ( (  \.---./  ) )
 *           '.__/o   o\__.'
 *              {=  ^  =}
 *               >  -  <
 *              /       \
 *             //       \\
 *            //|   .   |\\
 *            "'\       /'"_.-~^`'-.
 *               \  _  /--'         `
 *             ___)( )(___
 *            (((__) (__)))    
 *     
 *         虽然你我曾下落不明，但是我曾为你动过情
 *--------------------------------------------------------------------
 *   Created by 流浪者Zen on 2018/6/4.
 *  
 *   Describe:  设置状态栏颜色
 * 
 */
import android.app.Activity;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;

import qiu.niorgai.StatusBarCompat;

public class StatusBarCompatUtlis {


    public static StatusBarCompatUtlis statusBarCompatUtlis;

    public StatusBarCompatUtlis() {
    }

    public static StatusBarCompatUtlis getInsterface() {
        if (statusBarCompatUtlis == null) {
            synchronized (StatusBarCompatUtlis.class) {
                if (statusBarCompatUtlis == null) {
                    statusBarCompatUtlis = new StatusBarCompatUtlis();
                }
            }
        }
        return statusBarCompatUtlis;
    }

    //设置状态栏的颜色
    public void setStatusBarColor(Activity context, int color) {
        StatusBarCompat.setStatusBarColor(context, context.getResources().getColor(color));
    }

    //设置状态了透明度颜色
    public void setStatusBarColor(Activity context, int color, boolean judge) {
        if (judge) {
            StatusBarCompat.setStatusBarColor(context, context.getResources().getColor(color), 0);
        } else {
            StatusBarCompat.setStatusBarColor(context, context.getResources().getColor(color), 1);
        }
    }


    //半透明状态栏
    public void settranslucentStatusBar(Activity context) {
        StatusBarCompat.translucentStatusBar(context);
    }


    //半透明状态栏
    public void setStatusBarColorForCollapsingToolbar(Activity context, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout) {
        setStatusBarColorForCollapsingToolbar(context, appBarLayout, collapsingToolbarLayout);
    }
}






