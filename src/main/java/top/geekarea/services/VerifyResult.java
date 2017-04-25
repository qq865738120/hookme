package top.geekarea.services;

import top.geekarea.common.ComResult;
import top.geekarea.enums.VerifyResultEnum;

/**
 * 验证结果实体类
 * Created by code_xia on 2017/4/16.
 */
public class VerifyResult implements ComResult {

    private boolean result; //验证结果
    private String msg; //验证信息

    public VerifyResult() {

    }

    public VerifyResult(VerifyResultEnum verifyResultEnum) {
        this.result = verifyResultEnum.isResult();
        this.msg = verifyResultEnum.getMsg();
    }

    @Override
    public int getCode() {
        return 0;
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
        return "VerifyResult{" +
                "result=" + result +
                ", msg='" + msg + '\'' +
                '}';
    }
}
