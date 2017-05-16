package com.xiacms.goldfarming.mode_home.bean;

import java.io.Serializable;

/**
 * Created by Dell on 2017/5/2.
 */

public class Result implements Serializable {
    private int retCode = -1;
    private boolean retMsg;
    private Object retData;

    public Result() {
    }

    public Result(int retCode, boolean retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public Result(int retCode, boolean retMsg, Object retData) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public boolean isRetMsg() {
        return retMsg;
    }

    public void setRetMsg(boolean retMsg) {
        this.retMsg = retMsg;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }

    @Override
    public String toString() {
        return "Result{" +
                "retCode=" + retCode +
                ", retMsg=" + retMsg +
                ", retData=" + retData +
                '}';
    }
}
