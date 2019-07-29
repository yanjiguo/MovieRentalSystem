package com.yjg.vo;
/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/27
 *  @Description: 给前端返回数据的封装
 */
public class Result<T> {
    private int code;
    private String msg;
    private int totalPages;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
