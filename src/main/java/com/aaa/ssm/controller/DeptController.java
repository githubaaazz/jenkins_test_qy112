package com.aaa.ssm.controller;

import com.aaa.ssm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * fileName:DeptController
 * description:
 * author:zz
 * createTime:2019/11/23 14:15
 * version:1.0.0
 */
@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;


    /**
     * 部门列表
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Model model){
        List<Map> list = deptService.getList();
        model.addAttribute("deptList",list);
        return "dept/list";
    }
}
