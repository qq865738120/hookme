package top.geekarea.services;

import top.geekarea.enums.VerifyResultEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 密码验证
 * Created by code_xia on 2017/4/16.
 */
public class PasswordVerify implements FormVerify {

    public PasswordVerify() {

    }

    /**
     * 允许字母和数字
     * @param value
     * @return
     */
    @Override
    public VerifyResult form(String value) {
        char[] valueChars = value.toUpperCase().toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        if (value.length()<6) { //密码太短
            return new VerifyResult(VerifyResultEnum.PASSWORD_SHORTER);
        }
        for (char c: valueChars) {
            if (!(((c+0)>=65 && (c+0)<=90) || ((c+0)>=48 && (c+0)<=57))) { //如果字符不是字母或者数字
                return new VerifyResult(VerifyResultEnum.PASSWORD_NOT_LETTER_OR_NUMBER);
            }
            if (null != map.get(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        int size = 0;
        while (iterator.hasNext()) {
            Character key = (Character) iterator.next();
            int temp = map.get(key);
            if (temp > 4) { //密码包含重复四次以上的字符
                return new VerifyResult(VerifyResultEnum.PASSWORD_TOO_SIMPLE_ONE);
            }
            if ((key+0)>=48 && (key+0)<=57) {
                size++;
            }
        }
        if (size == keySet.size()){ //密码为纯数字
            return new VerifyResult(VerifyResultEnum.PASSWORD_TOO_SIMPLE_TWO);
        }
        return new VerifyResult(VerifyResultEnum.SUCCESS);
    }
}
