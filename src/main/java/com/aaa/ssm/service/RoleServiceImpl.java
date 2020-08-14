package com.aaa.ssm.service;

import com.aaa.ssm.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * fileName:RoleServiceImpl
 * description:
 * author:zz
 * createTime:2019/11/23 16:59
 * version:1.0.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Map> getListByUserId(int userId) {
        return roleDao.getListByUserId(userId);
    }
}
