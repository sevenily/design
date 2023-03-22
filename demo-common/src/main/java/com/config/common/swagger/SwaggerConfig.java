package com.config.common.swagger;/*
package com.example.mail.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


//swagger2的配置文件，在项目的启动类的同级文件建立
@Slf4j
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})   //@Profile 注解 标识加载在dev和test文件使用
//是否开启swagger，正式环境一般是需要关闭的（避免不必要的漏洞暴露！），可根据springboot的多环境配置进行设置
@ConditionalOnProperty(name = "swagger.enable",  havingValue = "true")
public class SwaggerConfig {

    @Autowired
    private Swagger2Properties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //页面标题
                        .title(swaggerProperties.getTitle())
                        //描述
                        .description(swaggerProperties.getDescription())
                        //创建人
                        .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                        .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                        //版本号
                        .version(swaggerProperties.getVersion())
                        .build())
                .enable(swaggerProperties.isEnable())
                .globalOperationParameters(swaggerProperties.isAddAuthorizationHeader() ? addGlobalOperationParameters() : null)
                .select()
                //当前包路径
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .build()    ;
    }

    private List<Parameter> addGlobalOperationParameters() {
        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder ticketPar = new ParameterBuilder();
        ticketPar.name("Authorization").description("用户Token")
                .modelRef(new ModelRef("string")).parameterType("header")
                //header中的ticket参数非必填，传空也可以
                .required(false).build();
        //根据每个方法名也知道当前方法在设置什么参数
        pars.add(ticketPar.build());
        return pars;
    }

}
*/
