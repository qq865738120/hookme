package top.geekarea.services;

import top.geekarea.common.ComResultImp;
import top.geekarea.enums.UserResultEnum;

/**
 * 用户业务统一返回结果
 * Created by code_xia on 2017/4/18.
 */
public class UserResult extends ComResultImp {

    public UserResult() {

    }
    public UserResult(UserResultEnum userResultEnum) {
        super(userResultEnum.getCode(), userResultEnum.isResult(), userResultEnum.getMsg());
    }
}
