package com.aaa.ssm.service;

import com.aaa.ssm.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:DeptServiceImpl
 * description:
 * author:zz
 * createTime:2019/11/23 14:13
 * version:1.0.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Map> getList() {
        return deptDao.getList();
    }
}
