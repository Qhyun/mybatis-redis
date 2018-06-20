package com.example.mybatisredis.Mapper;

import com.example.mybatisredis.Entity.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM USERS")
    public List<UserEntity> getUserAll();

    @Select("SELECT NAME, AGE FROM USERS WHERE ID = #{id}")
    public UserEntity getUserById(@Param("id") Integer id);

    @Insert("INSERT INTO USERS VALUES(null, #{name}, #{age})")
    public int createUser(@Param("name") String name, @Param("age") Integer age);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    public int deleteUser(@Param("id") Integer id);
}
