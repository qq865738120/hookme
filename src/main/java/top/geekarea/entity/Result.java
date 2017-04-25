package top.geekarea.entity;

/**
 * http请求返回的包装类
 * Created by code_xia on 2017/3/31.
 */
public class Result<T> {

    private Integer code; //错误码
    private String msg; //提示信息
    private T data; //内容

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
