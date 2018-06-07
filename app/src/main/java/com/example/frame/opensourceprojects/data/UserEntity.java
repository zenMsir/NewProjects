package com.example.frame.opensourceprojects.data;
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
 *   Describe:
 * 
 */

public class UserEntity extends BaseBean  {

    private long id;
    private String name;
    private String pass;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
