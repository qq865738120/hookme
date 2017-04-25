package top.geekarea.enums;

/**
 * Created by code_xia on 2017/4/16.
 */
public enum VerifyResultEnum {
    USER_NAME_SHORTER(false, "用户名不能低于6位"),
    USER_NAME_NOT_LETTER_OR_NUMBER(false, "用户名只能由数字或者字母组成"),
    EMAIL_FORMAT_LAYOUT_ERROR(false, "邮箱格式不正确"),
    SUCCESS(true, "成功"),
    PASSWORD_SHORTER(false, "密码不能低于6位"),
    PASSWORD_NOT_LETTER_OR_NUMBER(false, "密码只能由数字或者字母组成"),
    PASSWORD_TOO_SIMPLE_ONE(false, "密码包含太多重复字符"),
    PASSWORD_TOO_SIMPLE_TWO(false, "密码不能为纯数字"),
    PASSWORD_NOT_SAME(false, "两次输入的密码不一致"),
    AGE_OUT_OF_RANGE(false, "年龄超出范围"),
    AGE_IS_NOT_A_PURE_DIGITAL(false, "年龄必须是纯数字"),
    AGE_SHORTER(false, "年龄不能为空")
    ;

    private boolean result;
    private String msg;

    VerifyResultEnum(boolean result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }
}
