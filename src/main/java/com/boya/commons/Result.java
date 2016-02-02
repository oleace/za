package com.boya.commons;

import java.util.List;

/**
 * Created in boya on 14-12-2.
 *
 * @author lz
 */
public class Result {


    public static final int SUCCESS = -1;
    /**
     * 未知错误
     */
    public static final int ERROR = 1;
    /**
     * 参数为空
     */
    public static final int PARAMETERNULL = 2;
    /**
     * 数据库操作异常
     */
    public static final int DATAACCESSERROR = 3;

    private int resultCode;

    private String msg;

    private Object data;

    private List datas;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List getDatas() {
        return datas;
    }

    public void setDatas(List datas) {
        this.datas = datas;
    }
}
