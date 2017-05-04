package top.geekarea.services.verify;

import top.geekarea.services.result.VerifyResult;

/**
 * 表单验证接口
 * Created by code_xia on 2017/4/16.
 */
public interface FormVerify {

    VerifyResult form(String value);
}
