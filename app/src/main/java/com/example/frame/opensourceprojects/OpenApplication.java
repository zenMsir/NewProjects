package com.example.frame.opensourceprojects;
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
 *   Describe:  总管理器，用于管理第三方和注入
 * 
 */
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.frame.opensourceprojects.common.utlis.OverallHandler;

public class OpenApplication extends MultiDexApplication{

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        OverallHandler.getInterface().init(this);
    }
}
