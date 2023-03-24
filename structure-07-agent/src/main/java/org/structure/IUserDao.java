package org.structure;

import org.structure.agent.Select;

/**
 * @ClassName: UserDao
 * @Description: Dao接口，添加自定义注解
 * @Author: seven
 * @CreateTime: 2023-03-24 10:18
 * @Version: 1.0
 **/

public interface IUserDao {
    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);
}
