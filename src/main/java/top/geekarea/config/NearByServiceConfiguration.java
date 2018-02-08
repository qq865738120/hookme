package top.geekarea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 附近模块配置类
 */
@Component //使该类能在其它类中使用@Autowrite
@ConfigurationProperties(locations = "classpath:config/my_application.yml", prefix = "nearByService")
public class NearByServiceConfiguration {

    private double startDistance;

    private double maxDistance;

    public double getStartDistance() {
        return startDistance;
    }

    public void setStartDistance(double startDistance) {
        this.startDistance = startDistance;
    }

    public double getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(double maxDistance) {
        this.maxDistance = maxDistance;
    }
}
