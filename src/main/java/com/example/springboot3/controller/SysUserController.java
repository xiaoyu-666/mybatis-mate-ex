package com.example.springboot3.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot3.entity.SysUserEntity;
import com.example.springboot3.service.SysUserService;
import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ZhaoZhongYu
 * @since 2023-03-06
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SysUserEntity> getUserList() {
        List<SysUserEntity> list = sysUserService.list();
        return list;
    }

    @RequestMapping(value = "/listById", method = RequestMethod.GET)
    public SysUserEntity getUserList(@PathParam("id") Long id) {
        SysUserEntity entity = sysUserService.getById(id);
        return entity;
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser() {

        ArrayList<SysUserEntity> arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            SysUserEntity userEntity = new SysUserEntity();
            userEntity.setUsername("用户名"+i);
            userEntity.setPassword("test999"+i);
            userEntity.setIsRoot(0);
            userEntity.setTellerId("9999"+i);
            userEntity.setRealname("test999"+i);
            userEntity.setIsDel(0);
            userEntity.setRemark("测试用户名加密解密功能");
            arrayList.add(userEntity);
        }
        sysUserService.saveBatch(arrayList);

    }


}
