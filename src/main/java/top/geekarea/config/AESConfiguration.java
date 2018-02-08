package top.geekarea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * aes加密算法配置类
 */
@Component
@ConfigurationProperties( locations = "classpath:config/my_application.yml", prefix = "aes")
public class AESConfiguration {

    private String secretKey;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
