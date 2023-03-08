package com.example.springboot3.service.impl;

import com.example.springboot3.entity.SysUserEntity;
import com.example.springboot3.mapper.SysUserMapper;
import com.example.springboot3.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZhaoZhongYu
 * @since 2023-03-06
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {

}
