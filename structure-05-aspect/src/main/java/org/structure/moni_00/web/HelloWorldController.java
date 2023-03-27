package org.structure.moni_00.web;

import design.door.annotation.DoDoor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.structure.moni_00.domain.UserInfo;

/**
 * @ClassName: HelloWorldController
 * @Description: 提供查询用户信息的接口
 * @Author: seven
 * @CreateTime: 2023-03-24 15:20
 * @Version: 1.0
 **/

@RestController
public class HelloWorldController {
    @Value("${server.port}")
    private int port;

    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"⾮白名单可访问用户拦截！\",\"name\":null,\"age\":null,\"address\":null}")
    @GetMapping(path = "/api/queryUserInfo")
    public UserInfo queryUserInfo(@RequestParam String userId){
        return new UserInfo("虫虫"+userId, 19, "北京");

    }
}
