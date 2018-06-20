package com.example.mybatisredis.Service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private long expireTime = 60L;

    public void setString(String key, String value) {
        this.setReids(key, value);
    }

    public void setList(String key, List<?> value) {
        this.setReids(key, value);
    }

    public void setObject(String key, Object value) {
        this.setReids(key, value);
    }

    private void setReids(String key, Object value) {
        if (value instanceof String) {
            String strValue = (String) value;
            stringRedisTemplate.opsForValue().set(key, strValue, expireTime, TimeUnit.SECONDS);
        }else {
            String strValue = JSON.toJSONString(value);
            stringRedisTemplate.opsForValue().set(key, strValue, expireTime, TimeUnit.SECONDS);
        }
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public void deleteRedis(String key) {
        stringRedisTemplate.delete(key);
    }
}
