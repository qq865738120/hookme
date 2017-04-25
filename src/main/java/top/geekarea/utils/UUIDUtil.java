package top.geekarea.utils;

import java.util.UUID;

/**
 * 激活码生成工具类
 * Created by code_xia on 2017/4/20.
 */
public class UUIDUtil {

    /**
     * 随机生成64位UUID
     * @return
     */
    public static String createCode() {
        return UUID.randomUUID().toString().replace("-", "")+
                UUID.randomUUID().toString().replace("-", "");
    }
}
