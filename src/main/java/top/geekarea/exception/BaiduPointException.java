package top.geekarea.exception;

import top.geekarea.enums.BaiduPointEnum;

/**
 * 百度定位接口异常类
 */
public class BaiduPointException extends RuntimeException {

    private Integer code;

    public BaiduPointException(BaiduPointEnum baiduPointEnum) {
        super(baiduPointEnum.getMessage());
        this.code = baiduPointEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
