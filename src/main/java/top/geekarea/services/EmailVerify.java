package top.geekarea.services;

import top.geekarea.enums.VerifyResultEnum;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 邮箱验证
 * Created by code_xia on 2017/4/20.
 */
public class EmailVerify implements FormVerify {

    @Override
    public VerifyResult form(String value) {
        String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(value);
        boolean isMatched = matcher.matches();
        if (!isMatched) { //验证通过
            return new VerifyResult(VerifyResultEnum.EMAIL_FORMAT_LAYOUT_ERROR);
        } else {
            return new VerifyResult((VerifyResultEnum.SUCCESS));
        }
    }
}
