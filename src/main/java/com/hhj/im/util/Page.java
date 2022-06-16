package com.hhj.im.util;

import java.util.List;

public class Page<T> {
    private int pageNumber;
    private int pageSize;
    private int total;
    private List<T> rows;

    private int pageCount;
    private int pre;
    private int next;
    private int start; //limit ?,?
    private boolean first;
    private boolean last;

    public int getPageCount() {
        return (getTotal()+getPageSize()-1)/getPageSize();
    }

    public int getPre() {
        if(getPageNumber()==1)
            return 1;
        return getPageNumber()-1;
    }

    public int getNext() {
        if(getPageNumber()==getPageCount())
            return getPageCount();
        return getPageNumber()+1;
    }

    public int getStart() {
        return (getPageNumber()-1)*pageSize;
    }


    public boolean isFirst() {
        return getPageNumber()==1;
    }

    public boolean isLast() {
        return getPageNumber()==getPageCount();
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}


