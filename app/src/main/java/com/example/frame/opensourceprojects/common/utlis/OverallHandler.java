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
 *   Describe:  创建App级别的error 处理器
 * 
 */

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class OverallHandler implements Thread.UncaughtExceptionHandler {


    public static OverallHandler handler;

    public Thread.UncaughtExceptionHandler exceptionHandler;

    private Context mContext;


    public static OverallHandler getInterface(){
        if (handler == null){
            synchronized (OverallHandler.class){
                if (handler == null){
                    handler = new OverallHandler();
                }
            }
        }
        return handler;
    }

    public void init(Context context){
        this.mContext = context;
        exceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
    }



    @Override
    public void uncaughtException(Thread t, Throwable e) {

        if (!error(e) && handler !=null){

            handler.uncaughtException(t,e);
        } else {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            // 退出程序
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    private boolean error(Throwable e) {
        if (e == null){
            return false;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.loop();
                Toast.makeText(mContext,"抱歉，程序出现异常",Toast.LENGTH_SHORT).show();
                Looper.prepare();
            }
        }).start();
        return true;
    }
}
