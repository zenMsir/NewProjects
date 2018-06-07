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
 *         虽然你我下落不明，但是我曾为你动过情
 *--------------------------------------------------------------------
 *   Created by 流浪者Zen on 2018/6/7.
 *  
 *   Describe:  管理App生命周期
 * 
 */

import android.app.Activity;
import java.util.Stack;
public class AppManagerUtlis {

    public static AppManagerUtlis utlis;

    /*栈对象管理*/
    private Stack<Activity> activities = new Stack<>();

    public AppManagerUtlis() {
    }

    public static AppManagerUtlis getInterface() {
        if (utlis == null) {
            synchronized (AppManagerUtlis.class) {
                if (utlis == null) {
                    utlis = new AppManagerUtlis();
                }
            }
        }
        return utlis;
    }

    /*进栈*/
    public void addActivity(Activity activity) {

        try {

            if (activity == null) {
                return;
            }
            activities.add(activity);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /*移除指定的activity*/
    public void removce(Activity activity) {
        try {

            for (int i = activities.size() - 1; i >= 0; i--) {
                Activity currenActivity = activities.get(i);
                if (currenActivity.getClass().equals(activity.getClass())) {
                    currenActivity.finish();
                    activities.remove(i);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*删除当前的activity*/
    public void removceCurren() {
        try {

            Activity currentActivity = activities.get(activities.size() - 1);
            currentActivity.finish();
            activities.remove(activities.size()  - 1);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //删除所有的activity
    public void removeAll(){
        for (int i = activities.size(); i >= 0 ; i--) {
            Activity activity = activities.get(i);
            activity.finish();
            activities.remove(activity);

        }
    }

    //返回栈的大小
    public int size(){
        return activities.size();
    }

    //获取当前的activity
    public Activity currentActivity(){
        Activity currentActivity = activities.get(activities.size() - 1);
        return currentActivity;
    }


}
