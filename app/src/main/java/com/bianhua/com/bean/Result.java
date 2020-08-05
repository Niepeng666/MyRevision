package com.bianhua.com.bean;

public class Result<T> {
    String code;
    String des;
    T data;

    public Result(String code, String des, T data) {
        this.code = code;
        this.des = des;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
