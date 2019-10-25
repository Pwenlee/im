package com.lee.im.user.service.impl;

import com.lee.im.user.api.entity.User;
import com.lee.im.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public boolean insertUser(@RequestBody  User user) {
        mongoTemplate.insert(user);
        return Boolean.TRUE;
    }
}
