package top.geekarea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义配置文件实体类
 * Created by code_xia on 2017/4/27.
 */
@Component //使该类能在其它类中使用@Autowrite
@ConfigurationProperties(locations = "classpath:config/my_application.yml", prefix = "email")
public class MyMailConfiguration {

    private String name;

    private String password;

    private String host;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "MyMailConfiguration{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
