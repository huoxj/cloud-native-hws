package io.daocloud.adminservice.controller;

import io.daocloud.adminservice.service.UserService;
import io.daocloud.adminservice.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    // 增加用户api
    @PostMapping("/user")
    @ResponseBody
    public Object add(@RequestBody UserVO userVO) {
        return userService.add(userVO);
    }

    // 负载均衡测试api
    @GetMapping("/port")
    @ResponseBody
    public String port() {
        return userService.port();
    }

}
