package com.qf.market.tool;

/**
*分页工具类
 * @version 1.0
 * @auth sx
 * @date 2020/3/31
 */
public class PageTool {
    /**
    *当前页面
    */
    private Integer currPage;
    /**
     *每页显示记录条数
     */
    private Integer pageCount;
    /**
     *总记录数
     */
    private Integer totalCount;
    /**
     *总页数
     */
    private Integer totalPage;
    /**
     *当前页起始记录数
     */
    private Integer start;

    /**
     *获得当前页码
     *@return Integer
     */
    public Integer getCurrPage() {
        return currPage;
    }

    /**
     *设置当前的页码
     *@param currPage
     *@return void
     */
    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    /**
     *获得每页的记录条数
     *@return Integer
     */
    public Integer getPageCount() {
        return pageCount;
    }

    /**
     *设置每页的记录条数
     *@param pageCount
     *@return void
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    /**
     *获得总记录数
     *@return Integer
     */
    public Integer getTotalCount() {
        return totalCount;
    }

    /**
     *设置总记录数
     *@param totalCount
     *@return void
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    /**
     *获得总页数
     *@return Integer
     */
    public Integer getTotalPage() {
        return totalPage;
    }

    /**
     *设置总页数
     *@param totalCount
     * @param pageCount
     *@return void
     */
    public void setTotalPage(Integer totalCount,Integer pageCount) {
        if (totalCount%pageCount==0){
            this.totalPage=totalCount/pageCount;
        }else{
            this.totalPage=totalCount/pageCount+1;
        }

    }

    /**
     *获得当前页起始记录数
     *@return Integer
     */
    public Integer getStart() {
        return start;
    }

    /**
    *设置当前页起始记录数
    *@param start
    *@return void
    */
    public void setStart(Integer start) {
        this.start = start;
    }
}
