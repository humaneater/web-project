package com.example.dao;

import com.example.pojo.UserModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : lqy
 * @Date : 2021/2/23 17:59
 */
@Repository
@Mapper
public interface UserModelMapper {
    @Insert("INSERT INTO user (`name`, `password`, `age`, `gender`) VALUES (#{name}, #{password}, #{age}, #{gender});")
    public int add( UserModel userModel);
    @Delete("DELETE FROM user WHERE (id=#{id});")
    public int delete(Integer id);
    @Update("UPDATE user SET name=#{userModel.name},password=#{userModel.password} WHERE (id=#{id});")
    public int update(UserModel userModel,Integer id);
//    public UserModel selectOne();
    @Select("SELECT * from user")
    public List<UserModel> selectAll();


}
