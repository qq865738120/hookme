package top.geekarea.enums;

/**
 * 用户业务结果枚举
 * Created by code_xia on 2017/4/18.
 */
public enum UserResultEnum {

    USER_NAME_NULL(001, false, "用户名不能为空"),
    PASSWORD_NULL(002, false, "密码不能为空"),
    LOGIN_SUCCESS(003, true, "登陆成功"),
    USER_NAME_OF_PASSWORD_ERROE(004, false, "用户名或密码不正确"),
    USER_EXIST(005, false, "用户不存在"),
    ;

    private int code;
    private boolean result;
    private String msg;

    UserResultEnum(int code, boolean result, String msg) {
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
