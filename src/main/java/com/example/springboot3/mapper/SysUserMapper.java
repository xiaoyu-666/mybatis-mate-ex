package com.example.springboot3.mapper;

import com.example.springboot3.entity.SysUserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ZhaoZhongYu
 * @since 2023-03-06
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

}
