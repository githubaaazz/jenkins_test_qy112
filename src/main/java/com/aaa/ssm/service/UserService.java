package com.aaa.ssm.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:UserService
 * description:
 * author:zz
 * createTime:2019/11/23 16:11
 * version:1.0.0
 */
public interface UserService {

    /**
     * 根据参数查询用户列表
     * @param map
     * @return
     */
    List<Map> getList(Map map);
}
