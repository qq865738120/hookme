package top.geekarea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 百度定位api配置类
 */
@Component
@ConfigurationProperties( locations = "classpath:config/my_application.yml", prefix = "baidupoint")
public class BaiduPointCongiguration {

    private String dns; //DNS域名

    private String ak; //app key

    private String coor; //坐标类型

    private String ip; //ip地址

    private String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getCoor() {
        return coor;
    }

    public void setCoor(String coor) {
        this.coor = coor;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return this.getDns()+"?ip="+this.getIp()+"&ak="+this.getAk()+"&coor="+this.getCoor();
    }
}
