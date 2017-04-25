package top.geekarea.DAO;

import top.geekarea.common.ComResult;
import top.geekarea.enums.DaoResultEnum;

/**
 * dao统一结果返回类
 * Created by code_xia on 2017/4/18.
 */
public class DaoResult implements ComResult {

    private int code;
    private boolean result;
    private String msg;

    public DaoResult() {

    }

    public DaoResult(DaoResultEnum daoResultEnum) {
        this.code = daoResultEnum.getCode();
        this.result = daoResultEnum.isResult();
        this.msg = daoResultEnum.getMsg();
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "DaoResult{" +
                "code=" + code +
                ", result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}
