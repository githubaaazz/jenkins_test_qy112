package com.aaa.ssm.service;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:DeptService
 * description:
 * author:zz
 * createTime:2019/11/23 14:13
 * version:1.0.0
 */
public interface DeptService {

    /**
     * 部门列表
     * @return
     */
    List<Map> getList();
}
