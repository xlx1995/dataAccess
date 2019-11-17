package com.xlx.service;

import com.xlx.db.pojo.User;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    User findUserById(String userId);

    String testTransaction();
}
