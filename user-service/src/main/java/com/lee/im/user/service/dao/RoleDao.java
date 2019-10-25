package com.lee.im.user.service.dao;

import com.lee.im.user.api.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {

    List<Role> getRoleList();
}
