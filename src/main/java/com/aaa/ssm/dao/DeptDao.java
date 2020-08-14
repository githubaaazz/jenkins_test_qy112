package com.aaa.ssm.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * fileName:DeptDao
 * description:
 * author:zz
 * createTime:2019/11/23 14:10
 * version:1.0.0
 */
public interface DeptDao {

    /**
     * 部门列表
     * @return
     */
    @Select("select  * from dept")
    List<Map>  getList();
}
