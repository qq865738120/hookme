package top.geekarea.enums;

/**
 * FormVerify工厂类参数信息
 * Created by code_xia on 2017/4/16.
 */
public enum FormVerifyEnum {
    USER_NAME("top.geekarea.services.verify.UserNameVerify"),
    EMAIL("top.geekarea.services.verify.EmailVerify"),
    PASSWORD("top.geekarea.services.verify.PasswordVerify"),
    AGE("top.geekarea.services.verify.AgeVerify"),
    ;

    private String className;

    FormVerifyEnum(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }
}
