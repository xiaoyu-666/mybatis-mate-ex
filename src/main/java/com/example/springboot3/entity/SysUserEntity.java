package com.example.springboot3.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.example.springboot3.config.JsonBindStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import mybatis.mate.annotation.Algorithm;
import mybatis.mate.annotation.FieldEncrypt;
import mybatis.mate.annotation.JsonBind;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ZhaoZhongYu
 * @since 2023-03-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("sys_user")
@JsonBind(JsonBindStrategy.Type.departmentRole)
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名	姓名（账号）
     */

    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    @FieldEncrypt(algorithm = Algorithm.RSA)
    private String password;

    /**
     * 真实姓名
     */
    @TableField("realname")
    private String realname;

    /**
     * 出纳员编号，柜员号
     */
    @TableField("teller_id")
    private String tellerId;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 是否是管理员，1=是，0=否，如果是管理员账号则禁止删除
     */
    @TableField("is_root")
    private Integer isRoot;

    /**
     * 是否删除，软删除，1为删除，0为未删除
     */
    @TableField("is_del")
    private Integer isDel;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新人
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;


}