/**
 * @ClassName Tprovider
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/7 15:12
 * @Version 1.0
 */
package com.qf.market.entity;

import java.util.Date;

public class Tprovider {
    private int pid;//供应商编号
    private String pname;//供应商名称
    private Date pdate;//创建时间
    private String ptel;//联系电话
    private String pcontact;//联系人
    private String pfax;//传真

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public String getPtel() {
        return ptel;
    }

    public void setPtel(String ptel) {
        this.ptel = ptel;
    }

    public String getPcontact() {
        return pcontact;
    }

    public void setPcontact(String pcontact) {
        this.pcontact = pcontact;
    }

    public String getPfax() {
        return pfax;
    }

    public void setPfax(String pfax) {
        this.pfax = pfax;
    }

    @Override
    public String toString() {
        return "Tprovider{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdate=" + pdate +
                ", ptel='" + ptel + '\'' +
                ", pcontact='" + pcontact + '\'' +
                ", pfax='" + pfax + '\'' +
                '}';
    }
}
