package com.hfut.entity;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AjaxResult<T> {
    private int status;
    private List<T> data;
    private String msg = "";
    private int count = -1;


    public void ok() {
        this.status = 0;
        setMsg("操作成功。");
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
        if (this.count == -1) {
            this.count = data.size();
        }
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
        return JSON.toJSONString(this);
    }
}

