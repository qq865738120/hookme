package top.geekarea.services;

import top.geekarea.enums.FormVerifyEnum;

/**
 * 表单验证工厂
 * Created by code_xia on 2017/4/16.
 */
public class FormVerifyFactory {

    public FormVerifyFactory() {

    }

    /**
     * 通过类名获取实例
     * @param formVerifyEnum
     * @return
     */
    public FormVerify getVerifyByClass(FormVerifyEnum formVerifyEnum) {
        try {
            return (FormVerify) Class.forName(formVerifyEnum.getClassName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
