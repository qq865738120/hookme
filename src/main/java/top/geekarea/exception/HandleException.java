package top.geekarea.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.geekarea.common.HTTPResult;
import top.geekarea.utils.ResultUtil;

/**
 * 异常捕获类
 * Created by code_xia on 2017/3/31.
 */
@ControllerAdvice
public class HandleException {

    private final static Logger logger = LoggerFactory.getLogger(HandleException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HTTPResult handleException(Exception e) {
        if (e instanceof MyException){
            MyException myException = (MyException) e;
            return ResultUtil.error(myException.getCode(), myException.getMessage());
        }else{
            logger.error("【系统异常】", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
