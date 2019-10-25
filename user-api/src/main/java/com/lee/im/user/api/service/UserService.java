package com.lee.im.user.api.service;

import com.lee.im.user.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "user-service")
public interface UserService {

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    boolean insertUser(@RequestBody  User user);
}
