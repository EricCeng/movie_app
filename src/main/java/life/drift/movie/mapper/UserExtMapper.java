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
}
