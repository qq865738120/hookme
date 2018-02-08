package top.geekarea.utils;

import top.geekarea.common.HTTPResult;

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
    public static HTTPResult success(Object object) {
        HTTPResult HTTPResult = new HTTPResult();
        HTTPResult.setCode(0);
        HTTPResult.setMsg("成功");
        HTTPResult.setData(object);
        return HTTPResult;
    }

    /**
     * 成功时调用此方法
     * @return
     */
    public static HTTPResult success() {
        return success(null);
    }

    /**
     * 失败时调用此方法
     * @param code
     * @param msg
     * @return
     */
    public static HTTPResult error(Integer code, String msg) {
        HTTPResult HTTPResult = new HTTPResult();
        HTTPResult.setCode(code);
        HTTPResult.setMsg(msg);
        return HTTPResult;
    }
}
