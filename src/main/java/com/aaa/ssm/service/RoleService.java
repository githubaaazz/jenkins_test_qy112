package com.aaa.ssm.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:RoleService
 * description:
 * author:zz
 * createTime:2019/11/23 16:59
 * version:1.0.0
 */
public interface RoleService {

    /**
     * 根据用户ID获取角色列表
     * @param userId
     * @return
     */
    List<Map> getListByUserId(int userId);
}
