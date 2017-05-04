package top.geekarea.services.verify;

import top.geekarea.enums.VerifyResultEnum;
import top.geekarea.services.result.VerifyResult;

/**
 * 用户名验证
 * Created by code_xia on 2017/4/16.
 */
public class UserNameVerify implements FormVerify {

    public UserNameVerify() {

    }

    /**
     * 用户名只允许使用字母和数字
     * @param value
     * @return
     */
    @Override
    public VerifyResult form(String value) {
        char[] valueChars = value.toUpperCase().toCharArray();
        if (value.length()<6) { //用户名太短
            return new VerifyResult(VerifyResultEnum.USER_NAME_SHORTER);
        }
        for (char c: valueChars) {
            if (!(((c+0)>=65 && (c+0)<=90) || ((c+0)>=48 && (c+0)<=57))) { //如果字符不是字母或者数字
                return new VerifyResult(VerifyResultEnum.USER_NAME_NOT_LETTER_OR_NUMBER);
            }
        }
        return new VerifyResult(VerifyResultEnum.SUCCESS);
    }
}
