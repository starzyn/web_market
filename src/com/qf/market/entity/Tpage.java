/**
 * @ClassName Tpage
 * @Description TODO
 * @Author Administrator
 * @Date 2020/4/19 14:22
 * @Version 1.0
 */
package com.qf.market.entity;
/**
 * @Author starzyn
 * @Description 创建实体类，用来分页
 * @Date 14:22 2020/4/19
 * @Param 
 * @return 
 **/
public class Tpage {
    private int pos;//当前页面
    private int totalPage;//总页面
    public static int pageCount=5;//每页的记录条数
    private int start;//开始记录数
    private int end;//结束记录数

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
