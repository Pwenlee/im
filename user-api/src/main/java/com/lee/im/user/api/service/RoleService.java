package com.lee.im.user.api.service;

import com.lee.im.user.api.entity.Role;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "user-service")
public interface RoleService {

    @RequestMapping(value = "/getRoleList",method = RequestMethod.GET)
    List<Role> getRoleList();
}
