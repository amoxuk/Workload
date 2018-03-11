package com.hfut.entity;

import java.util.List;


public class AjaxResult<T> {
    private int status;
    private List<T> data;
    private String msg="";
    private int count;
    public void ok() {
        this.status = 0;
    }
    public void failed() {
        this.status = 1;
    }

    public int getStatus() {
        return status;
    }


    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
        count = data.size();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "AjaxResult{" +
                "status=" + status +
                ", data=" + data.toString()+
                ", msg='" + msg + '\'' +
                ", count=" + count +
                '}';
    }
}

