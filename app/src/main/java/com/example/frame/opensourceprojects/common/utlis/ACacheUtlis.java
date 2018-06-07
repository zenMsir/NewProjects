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
 *   Describe: Acache 缓存的封装
 * 
 */

import android.content.Context;

import com.example.frame.opensourceprojects.common.Confing;
import com.example.frame.opensourceprojects.data.UserEntity;

public class ACacheUtlis {


    public static ACacheUtlis aCacheUtlis;

    private Context mContext;

    public ACacheUtlis() {
    }

    public ACacheUtlis getInterface(Context context){
        this.mContext = context;
        if (aCacheUtlis == null){
            synchronized (ACacheUtlis.class){
                if (aCacheUtlis == null){
                    aCacheUtlis = new ACacheUtlis();
                }
            }
        }
        return aCacheUtlis;
    }



    /*添加信息到缓存中*/
    public void addUserMsg(UserEntity entity){
        ACache.get(mContext).put(Confing.USERNAME,entity.getName());
        ACache.get(mContext).put(Confing.PASSWORD,entity.getPass());
    }

    /*取出缓存*/
    public UserEntity getUserMsg(){
        UserEntity entity = new UserEntity();
        String userName = ACache.get(mContext).getAsString(Confing.USERNAME);
        String passWord = ACache.get(mContext).getAsString(Confing.PASSWORD);
        entity.setName(userName);
        entity.setName(passWord);
        return entity;
    }


    /*移除用户*/
    public void removceUser(){

    }


    /*清空所有数据*/
    public void clear(){
        ACache.get(mContext).clear();
    }
}
