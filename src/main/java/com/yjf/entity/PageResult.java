package com.yjf.entity;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/21 17:25
 * @Description :分页实体
 */
public class PageResult<T> {

    //总记录数
    private static  Integer  pageSize=5;

    //当前页
    private Integer pageTotal;

    //当前页数据
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(Integer pageTotal, List<T> rows) {
        this.pageTotal = pageTotal;
        this.rows = rows;
    }

    public static Integer getPageSize() {
        return pageSize;
    }

    public static void setPageSize(Integer pageSize) {
        PageResult.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pageTotal=" + pageTotal +
                ", rows=" + rows +
                '}';
    }
}
