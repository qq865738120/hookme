package top.geekarea.services;

import top.geekarea.config.NearByServiceConfiguration;

/**
 * 数据接口
 * 为需要从dao层取数据的业务提供统一接口
 */
public interface DataService<T,U> {

    T getResult(NearByServiceConfiguration nearByServiceConfiguration, U... parms);
}
