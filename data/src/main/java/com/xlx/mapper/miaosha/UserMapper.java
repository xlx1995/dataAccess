package com.xlx.mapper.miaosha;

import com.xlx.db.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: 徐林啸
 * @Date: 2019/7/30 18:00
 * @Description:
 */
@Repository
public interface UserMapper {


    User findUserById(String user_id);

    Integer insertUser(User user);

    List<User> listUser();


}
