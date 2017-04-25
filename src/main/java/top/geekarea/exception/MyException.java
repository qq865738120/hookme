package top.geekarea.exception;

import top.geekarea.enums.ResultEnum;

/**
 * 自定义通用异常类
 * Created by code_xia on 2017/3/31.
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
