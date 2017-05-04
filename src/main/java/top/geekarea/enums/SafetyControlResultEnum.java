package top.geekarea.enums;

/**
 * 安全控制结果枚举
 * Created by code_xia on 2017/5/4.
 */
public enum SafetyControlResultEnum {
    REPEAT_COMMIT_SUCESS(1, true, "提交成功")
    ;

    private Integer code;
    private boolean result;
    private String msg;

    SafetyControlResultEnum(int code, boolean result, String msg) {
        this.code = code;
        this.result = result;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public boolean isResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }
}
