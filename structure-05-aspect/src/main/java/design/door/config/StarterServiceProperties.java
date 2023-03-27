package design.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: StarterServiceProperties
 * @Description:    配置类注解定义
 * @Author: seven
 * @CreateTime: 2023-03-24 16:42
 * @Version: 1.0
 **/

@ConfigurationProperties("design.door")
public class StarterServiceProperties {

    private String userStr;

    public String getUserStr() {
        return userStr;
    }


    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
