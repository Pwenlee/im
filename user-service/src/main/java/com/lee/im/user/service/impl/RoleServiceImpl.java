package com.lee.im.user.service.impl;

import com.lee.im.user.api.entity.Role;
import com.lee.im.user.api.service.RoleService;;
import com.lee.im.user.service.dao.RoleDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Override
    @RequestMapping(value = "/getRoleList",method = RequestMethod.GET)
    public List<Role> getRoleList() {
        return roleDao.getRoleList();
    }
}
