package com.xlx.mapper.slavel;

import com.xlx.db.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {

    List<Role> listRole();

    int delete(int id);

}
