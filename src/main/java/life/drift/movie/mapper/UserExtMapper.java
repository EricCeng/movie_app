package life.drift.movie.mapper;

import life.drift.movie.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserExtMapper {
    /**
     * 判断用户名是否存在
     */
    Integer findByUsername(@Param("username") String username);

    /**
     * 根据用户名和密码进行查询
     */
    User selectByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    /**
     * 判断手机号是否存在
     */
    Integer findByPhone(@Param("phone") String phone);

    /**
     * 判断邮箱是否存在
     */
    Integer findByEmail(@Param("email") String email);

    /**
     * 修改信息
     */
    int updateByPrimaryKey(@Param("user") User record);

}
