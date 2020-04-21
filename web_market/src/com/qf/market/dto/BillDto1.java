package com.qf.market.dto;

import java.sql.Date;

/**
 * 账单输出模板类
 * @version 1.0
 * @auth sx
 * @date 2020/4/8
 */
public class BillDto1 {
    /**
     *账单主键
     */
    private int bid;
    /**
     *商品名称
     */
    private String pname;
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
     *供应商名称
     */
    private String providerName;

    @Override
    public String toString() {
        return "BillDto1{" +
                "bid=" + bid +
                ", pname='" + pname + '\'' +
                ", bdate=" + bdate +
                ", bprice=" + bprice +
                ", ptype=" + ptype +
                ", providerName='" + providerName + '\'' +
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

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
