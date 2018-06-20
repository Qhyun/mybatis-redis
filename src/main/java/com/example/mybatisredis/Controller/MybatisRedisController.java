package com.example.mybatisredis.Controller;

import com.example.mybatisredis.Entity.UserEntity;
import com.example.mybatisredis.Service.MybatisRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisRedisController {

    @Autowired
    private MybatisRedisService mybatisRedisService;

    @RequestMapping("/getUserAll")
    public List<UserEntity> getUserAll() {
        return mybatisRedisService.getUserAll();
    }

    @RequestMapping("/getUserById")
    public UserEntity getUserById(Integer id) {
        return mybatisRedisService.getUserById(id);
    }

    @RequestMapping("/createUser")
    public String createUser(String name, Integer age) {
        int rs = mybatisRedisService.createUser(name, age);

        if (rs == 1) {
            return "Success!!!";
        }else {
            return "Error!!!!";
        }
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id) {
        mybatisRedisService.deleteUser(id);

        return "Success!!!!";
    }
}
