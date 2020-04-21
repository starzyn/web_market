package com.qf.market.entity;

import java.sql.Date;

/**
*账号类
 * @version 1.0
 * @auth sx
 * @date 2020/4/7
 */
public class Tbill {
    /**
    *账单主键
    */
    private int bid;
    /**
     *商品名称
     */
    private String pname;
    /**
     *商品单位
     */
    private String puntis;
    /**
     *商品数量
     */
    private int pcount;
    /**
     *创建时间
     */
    private Date bdate;
    /**
     *账单金额
     */
    private double bprice;
    /**
     *0未付款1付款
     */
    private int ptype;
    /**
     *供应商编号
     */
    private int pid;

    @Override
    public String toString() {
        return "Tbill{" +
                "bid=" + bid +
                ", pname='" + pname + '\'' +
                ", puntis='" + puntis + '\'' +
                ", pcount=" + pcount +
                ", bdate=" + bdate +
                ", bprice=" + bprice +
                ", ptype=" + ptype +
                ", pid=" + pid +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPuntis() {
        return puntis;
    }

    public void setPuntis(String puntis) {
        this.puntis = puntis;
    }

    public int getPcount() {
        return pcount;
    }

    public void setPcount(int pcount) {
        this.pcount = pcount;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public int getPtype() {
        return ptype;
    }

    public void setPtype(int ptype) {
        this.ptype = ptype;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
