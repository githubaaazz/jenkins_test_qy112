package com.aaa.ssm.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:UserDao
 * description:
 * author:zz
 * createTime:2019/11/23 16:04
 * version:1.0.0
 */
public interface UserDao {

    /**
     * 根据参数查询用户列表
     * @param map
     * @return
     */
    @Select("<script>select * from tb_user <where>" +
            "<if test='userN!=null'> and user_name = #{userN}</if>" +
            "<if test='passWord!=null'> and password = #{passWord}</if>" +
            "</where></script>")
    List<Map> getList(Map map);
}
