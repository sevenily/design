package design.door.config;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: StarterService
 * @Description:    配置服务类
 * @Author: seven
 * @CreateTime: 2023-03-24 16:42
 * @Version: 1.0
 **/

public class StarterService {
    private String userStr;

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    public String[] split(String separatorChar){
        return this.userStr.split(separatorChar);
    }
}
