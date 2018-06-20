package com.example.mybatisredis.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.mybatisredis.Entity.UserEntity;
import com.example.mybatisredis.Mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MybatisRedisService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisService redisService;

    @Cacheable(value = "user", key = "userAll")
    public List<UserEntity> getUserAll() {

//        String allKey = "userAll";
//
//        List<UserEntity> users = null;
//
//        String strValue = redisService.getString(allKey);
//
//        if (StringUtils.isNotEmpty(strValue)) {
//            users = JSON.parseArray(strValue, UserEntity.class);
//
//            if (users != null && !users.isEmpty()) return users;
//        }

        List<UserEntity> users = userMapper.getUserAll();
        log.info("从数据库中读取");

//        redisService.setList(allKey, users);

        return users;
    }

    @Cacheable(value = "user", key = "'user_' + #id")
    public UserEntity getUserById(Integer id) {

//        String userKey = "user_" + id.toString();
//
//        UserEntity user = null;
//
//        String strValue = redisService.getString(userKey);
//
//        if (StringUtils.isNotEmpty(strValue)) {
//            user = JSON.parseObject(strValue, UserEntity.class);
//
//            if (user != null) return user;
//        }

        UserEntity user = userMapper.getUserById(id);
        log.info("从数据库中读取");

//        redisService.setObject(userKey, user);

        return user;
    }

    public int createUser(String name, Integer age) {
        return userMapper.createUser(name, age);
    }

    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }
}
