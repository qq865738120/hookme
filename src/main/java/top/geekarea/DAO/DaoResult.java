package top.geekarea.DAO;

import top.geekarea.common.ComResult;
import top.geekarea.enums.DaoResultEnum;

/**
 * dao统一结果返回类
 * Created by code_xia on 2017/4/18.
 */
public class DaoResult<T> implements ComResult {

    private int code;
    private boolean result;
    private String msg;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"code\":")
                .append(code);
        sb.append(",\"result\":")
                .append(result);
        sb.append(",\"msg\":\"")
                .append(msg).append('\"');
        sb.append(",\"data\":")
                .append(data);
        sb.append('}');
        return sb.toString();
    }
}
