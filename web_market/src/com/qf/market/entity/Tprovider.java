package com.qf.market.entity;

import java.sql.Date;

/**
*供应商类
 * @version 1.0
 * @auth sx
 * @date 2020/4/7
 */
public class Tprovider {
    /**
    * 供应商编号
    */
    private int pid;
    /**
     * 供应商名称
     */
    private String pname;
    /**
     * 创建时间
     */
    private Date pdate;
    /**
     * 联系电话
     */
    private String ptel;
    /**
     * 联系人
     */
    private String pcontact;
    /**
     * 传真
     */
    private String pfax;

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
}
