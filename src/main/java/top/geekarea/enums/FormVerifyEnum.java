package top.geekarea.enums;

/**
 * FormVerify工厂类参数信息
 * Created by code_xia on 2017/4/16.
 */
public enum FormVerifyEnum {
    USER_NAME("top.geekarea.services.UserNameVerify"),
    EMAIL("top.geekarea.services.EmailVerify"),
    PASSWORD("top.geekarea.services.PasswordVerify"),
    AGE("top.geekarea.services.AgeVerify"),
    ;

    private String className;

    FormVerifyEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
