package top.geekarea.enums;

/**
 * dao统一返回结果枚举
 * Created by code_xia on 2017/4/18.
 */
public enum DaoResultEnum {

    USER_INCOMPLETE_INFORMATION(001, false, "用户信息不全"),
    USER_USER_NAME_REPETITION(002, false, "用户名不可用"),
    USER_USER_NAME_OR_EMAIL_REPETITION(003, false, "用户名或邮箱不可用"),
    USER_SAVE_SUCCESS_TO_NAME(004, true, "用户名注册成功"),
    USER_SAVE_SUCCESS_TO_EMAIL(005, true, "邮箱注册成功"),
    QUERY_SUCCESS(006, true, "查询成功"),
    QUERY_NULL(007, false, "查询结果为空")
    ;

    private int code;
    private boolean result;
    private String msg;

    DaoResultEnum(int code, boolean result, String msg){
        this.code = code;
        this.result = result;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public boolean isResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }
}
