package top.geekarea.utils;

import top.geekarea.entity.Result;

/**
 * 异常工具类
 * Created by code_xia on 2017/3/31.
 */
public class ResultUtil {

    /**
     * 成功时调用此方法
     * @param object
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 成功时调用此方法
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 失败时调用此方法
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
