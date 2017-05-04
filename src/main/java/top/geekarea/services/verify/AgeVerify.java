package top.geekarea.services.verify;

import top.geekarea.enums.VerifyResultEnum;
import top.geekarea.services.result.VerifyResult;

/**
 * 年龄验证
 * Created by code_xia on 2017/4/16.
 */
public class AgeVerify implements FormVerify {

    public AgeVerify() {

    }

    /**
     * 允许16-120的范围
     * @param value
     * @return
     */
    @Override
    public VerifyResult form(String value) {
        char[] valueChar = value.toCharArray();
        int cont = 0;
        if (value.length()<1) {
            return new VerifyResult(VerifyResultEnum.AGE_SHORTER);
        }
        for (char c : valueChar) {
            if ((c+0)>=48 && (c+0)<=57) { //如果是数字
                cont++;
            }
        }
        if (cont == value.length()) { //如果全部是数字
            int age = new Integer(value);
            if (age>15 && age<121) { //如果年龄在16-120之间
                return new VerifyResult(VerifyResultEnum.SUCCESS);
            } else { //不在16-120之间
                return new VerifyResult(VerifyResultEnum.AGE_OUT_OF_RANGE);
            }
        } else { //不是纯数字
            return new VerifyResult(VerifyResultEnum.AGE_IS_NOT_A_PURE_DIGITAL);
        }
    }
}
