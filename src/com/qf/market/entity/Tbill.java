/**
 * @ClassName Tbill
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/7 15:11
 * @Version 1.0
 */
package com.qf.market.entity;

import java.util.Date;

public class Tbill {
    private int bid;
    private String pname;
    private String punits;
    private  int pcount;
    private Date bdate;
    private double bprice;
    private int ptype;
    private int pid;

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

    public String getPunits() {
        return punits;
    }

    public void setPunits(String punits) {
        this.punits = punits;
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

    @Override
    public String toString() {
        return "Tbill{" +
                "bid=" + bid +
                ", pname='" + pname + '\'' +
                ", punits='" + punits + '\'' +
                ", pcount=" + pcount +
                ", bdate=" + bdate +
                ", bprice=" + bprice +
                ", ptype=" + ptype +
                ", pid=" + pid +
                '}';
    }
}
