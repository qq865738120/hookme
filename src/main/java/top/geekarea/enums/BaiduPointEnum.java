package top.geekarea.enums;

/**
 * 百度定位接口异常枚举
 */
public enum BaiduPointEnum {
    IP_NULL(0, "ip地址为空");

    private Integer code;

    private String message;

    BaiduPointEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
