package top.geekarea.enums;

/**
 * 用户实体字段枚举
 * Created by code_xia on 2017/4/17.
 */
public enum UserEnum {
    USER_ENUM("userName"),
    PASSWORD("password"),
    CREATE_DATA("createData"),
    BIRTHDAY("birthday"),
    NICK_NAME("nickName"),
    AGE("age"),
    SEX("sex"),
    EMAIL("mail"),
    PHONE_NUM("phoneNum"),
    ICON("icon"),
    TAG("tag"),
    RANK("rank"),
    ;

    private String value;

    UserEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
