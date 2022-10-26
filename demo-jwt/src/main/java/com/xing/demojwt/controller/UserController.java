package com.xing.demojwt.controller;

import com.xing.demojwt.entity.User;
import com.xing.demojwt.service.UserService;
import com.xing.demojwt.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String,Object> login(User user)
    {
        log.info("用户名："+user.getUsername());
        log.info("密码："+user.getPassword());
        Map<String,Object> map=new HashMap<>();
        try {
            userService.login(user);
            map.put("msg","登录成功");
            map.put("code","200");
            Map<String,String> payload=new HashMap<>();
            payload.put("name",user.getUsername());
            String token= JwtUtils.getToken(payload);
            map.put("token",token);

        }
        catch (Exception ex)
        {
            map.put("msg","登录失败");
        }

        return map;
    }
    @PostMapping("/test/verity")
    public  Map<String,String> verityToken(String token)
    {
        Map<String, String> map=new HashMap<>();
        map.put("msg","验证成功");
        map.put("state","true");
        return map;
    }
}