package design.door.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: StarterAutoconfigure
 * @Description:    自定义 配置类信息 获取
 * @Author: seven
 * @CreateTime: 2023-03-24 16:42
 * @Version: 1.0
 **/

@Configuration
@ConditionalOnClass(StarterService.class)
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoconfigure {
    @Autowired
    private StarterServiceProperties properties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "design.door", value = "enabled", havingValue = "true")
    StarterService starterService(){
        return new StarterService(properties.getUserStr());
    }
}
