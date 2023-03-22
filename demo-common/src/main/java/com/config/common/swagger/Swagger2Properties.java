package com.config.common.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("swagger")
@Data
public class Swagger2Properties {
    //页面标题
    private String title;
    private String description;
    private String termsOfServiceUrl;
    //版本
    private String version;
    private boolean addAuthorizationHeader;
    private String basePackage;
    private Contact contact;
    private boolean enable;

    @Data
    public static class Contact {
        private String name;
        private String email;
        private String url;
    }
}
