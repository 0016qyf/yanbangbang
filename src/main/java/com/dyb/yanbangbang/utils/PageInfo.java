package com.dyb.yanbangbang.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页的工具类
 *
 * Created by Tang on 2018/12/21 0021.
 */
public class PageInfo {

    private Integer size; //每页size
    private Integer current; //当前页
    private Integer pages; //总页数
    private List records; //每页的记录
    private Integer total; //总个数

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List getRecords() {
        return records==null?new ArrayList<>():records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public PageInfo() {

    }

    public PageInfo(Integer total, List records, Integer pages, Integer current, Integer size) {
        this.total = total;
        this.records = records;
        this.pages = pages;
        this.current = current;
        this.size = size;
    }

    public PageInfo(Integer current, Integer size, List record){
        if(record.size()>0) {
            this.total = record.size();
            size = size==null?10:size;
            this.size=size;
            this.pages = total % size == 0 ? total / size : total / size + 1;
            current = current == null ? 1 : current;
            current = current < 1 ? 1 : current;
            current = current > pages ? pages : current;
            this.current = current;
            List res = new ArrayList<>();
            if (current == pages) {
                for (int i = (current - 1) * size; i < total; i++) {
                    res.add(record.get(i));
                }
            } else {
                for (int i = (current - 1) * size; i < current * size; i++) {
                    res.add(record.get(i));
                }
            }
            this.records = res;
        }
    }

}
