/**
 * @ClassName Tuser
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/7 15:05
 * @Version 1.0
 */
package com.qf.market.entity;

public class Tuser {
    private int uid;//用户id
    private String uaccount;//用户账户
    private String upassword;//用户密码
    private String uname;//用户名称
    private int usex;//用户性别
    private int uage;//用户年龄
    private String utel;//用户密码
    private String utype;//用户类型

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUsex() {
        return usex;
    }

    public void setUsex(int usex) {
        this.usex = usex;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public String getUtype() {
        return utype;
    }

    public void setUtype(String utype) {
        this.utype = utype;
    }

    @Override
    public String toString() {
        return "Tuser{" +
                "uid=" + uid +
                ", uaccount='" + uaccount + '\'' +
                ", upassword='" + upassword + '\'' +
                ", uname='" + uname + '\'' +
                ", usex=" + usex +
                ", uage=" + uage +
                ", utel='" + utel + '\'' +
                ", utype='" + utype + '\'' +
                '}';
    }
}
