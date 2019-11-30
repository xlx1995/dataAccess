package com.xlx.service.master;

import com.xlx.db.pojo.User;

public interface UserService {

    User findByUsername(String username);

}
