/**
 * Copyright (C), 2015-2020, 京东
 * FileName: Page
 * Author:   jiamengfei3
 * Date:     2020/2/24 21:11
 * Description: 分页工具类
 */
package com.jmf.tmall.pojo;


/**
 *
 * 分页工具类
 *
 * @author: jiamengfei3
 * @Date: 2020/02/24 21:11
 * @since: 1.0.0
 */
public class Page {
    private int start;
    private int count;
    private int total;
    private String param;
    private final int defaultCount = 5;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Page() {
    }

    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public Page(int start, int count, int total) {
        this.start = start;
        this.count = count;
        this.total = total;
    }

    public Boolean isHasPrevious(){
        if(start<=0){
            return false;
        }
        return true;
    }

    public Boolean isHasNext(){
        if(start == getLast()){
            return false;
        }
        return true;
    }

    public int getLast(){
        int last = 0;
        if(total % count == 0){
            last =  total - count;
        }else{
            last =  total-total%count;
        }
        return last < 0 ? 0 : last;
    }

    public int getTotalPage(){
        if (total % count == 0){
            return total/count;
        }else{
            return  total/count + 1;
        }
    }
}