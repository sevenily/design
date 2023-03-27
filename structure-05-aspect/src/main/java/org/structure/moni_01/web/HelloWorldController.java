package org.structure.moni_01.web;

import org.springframework.web.bind.annotation.RequestParam;
import org.structure.moni_00.domain.UserInfo;

import java.util.ArrayList;

/**
 * @ClassName: HelloWorldController
 * @Description: 模拟API接口类 在里面添加白名单功能
 * 但类似此类的接口会有很多都需要修改，不推荐
 * @Author: seven
 * @CreateTime: 2023-03-24 15:41
 * @Version: 1.0
 **/

public class HelloWorldController {

    public UserInfo queryUserInfo(@RequestParam String userId){
        //做白名单拦截
        ArrayList<String> userList = new ArrayList<>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("cccc");
        if (!userList.contains(userId)){
            return new UserInfo("1111", "非白名单可访问用户拦截！");
        }
        return new UserInfo("虫虫："+ userId, 19, "北京");
    }
}
