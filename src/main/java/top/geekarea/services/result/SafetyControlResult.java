package top.geekarea.services.result;

import top.geekarea.common.ComResultImp;
import top.geekarea.enums.SafetyControlResultEnum;

/**
 * 安全控制结果类
 * Created by code_xia on 2017/5/4.
 */
public class SafetyControlResult extends ComResultImp {

    public SafetyControlResult() {

    }
    public SafetyControlResult(SafetyControlResultEnum safetyControlResultEnum) {
        super(safetyControlResultEnum.getCode(), safetyControlResultEnum.isResult(), safetyControlResultEnum.getMsg());
    }
    public SafetyControlResult(Integer code, Boolean result, String msg) {
        this.code = code;
        this.result = result;
        this.msg = msg;
    }
}
