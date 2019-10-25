package com.lee.im.user.controller.application;

import com.lee.im.user.api.entity.Role;
import com.lee.im.user.api.entity.User;
import com.lee.im.user.api.service.RoleService;
import com.lee.im.user.api.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableSwagger2
@EnableFeignClients(basePackages = "com.lee.im.user.api")
@RestController
@Api(description = "用户管理接口")
public class UserControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserControllerApplication.class, args);
    }

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public boolean insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @RequestMapping(value = "/getRoleList",method = RequestMethod.GET)
    public List<Role> getRoleList() {
        return roleService.getRoleList();
    }

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                // .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build()
                .apiInfo(testApiInfo());
    }

    private ApiInfo testApiInfo() {
        Contact contact = new Contact("李攀", "http://my.oschina.net/wangnian", "630238086@qq.com");
        ApiInfo apiInfo = new ApiInfo("某API接口",//大标题
                "REST风格API",//小标题
                "0.1",//版本
                "www.baidu.com",
                contact,//作者
                "主页",//链接显示文字
                "",//网站链接
                new ArrayList()
        );
        return apiInfo;
    }

}
