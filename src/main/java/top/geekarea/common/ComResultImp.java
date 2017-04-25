package top.geekarea.common;

/**
 * 统一结果基类
 * Created by code_xia on 2017/4/18.
 */
public class ComResultImp implements ComResult {

    protected int code;
    protected boolean result;
    protected String msg;

    public ComResultImp() {

    }
    public ComResultImp(int code, boolean result, String msg) {
        this.code = code;
        this.result = result;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    @Override
    public boolean isResult() {
        return result;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
