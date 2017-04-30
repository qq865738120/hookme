package top.geekarea.services;

import com.alibaba.fastjson.JSONObject;
import top.geekarea.enums.FormVerifyEnum;
import top.geekarea.enums.VerifyResultEnum;
import top.geekarea.utils.HttpServletUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 表单验证业务类
 * Created by code_xia on 2017/4/16.
 */
public class FormVerifyService {

    public FormVerifyService() {

    }

    /**
     * 注册表单验证方法
     * @return
     */
    public VerifyResult registerFormVerify(JSONObject jsonObject) {

        FormVerifyFactory formVerifyFactory = new FormVerifyFactory(); //创建验证工厂实例
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("password1", FormVerifyEnum.PASSWORD); //key：前端发送过来的json的key  value：表单验证枚举
        map.put("password2", FormVerifyEnum.PASSWORD);
        map.put("age", FormVerifyEnum.AGE);
        Iterator iterator = map.keySet().iterator();
        VerifyResult verifyResult;
        verifyResult = formVerifyFactory.getVerifyByClass(FormVerifyEnum.USER_NAME).form((String)jsonObject.get("userName")); //用户名验证
        VerifyResult verifyResult2 = formVerifyFactory.getVerifyByClass(FormVerifyEnum.EMAIL).form((String)jsonObject.get("userName")); //邮箱验证
        if (!verifyResult.isResult() && !verifyResult2.isResult()) {
            if (!verifyResult.isResult()) {
                return verifyResult;
            }
            if (!verifyResult2.isResult()) {
                return verifyResult2;
            }
        }
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            verifyResult = formVerifyFactory.getVerifyByClass((FormVerifyEnum) map.get(key)).form((String)jsonObject.get(key));
            if (!verifyResult.isResult()) { //如果没有通过验证
                return verifyResult;
            }
        }
        if (!jsonObject.get("password1").equals(jsonObject.get("password2"))) {
            verifyResult = new VerifyResult(VerifyResultEnum.PASSWORD_NOT_SAME);
            return verifyResult;
        }
        verifyResult = new VerifyResult(VerifyResultEnum.SUCCESS);
        return verifyResult;
    }
}
