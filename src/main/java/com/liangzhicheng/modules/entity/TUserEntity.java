package com.liangzhicheng.modules.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.LogicDelete;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * TUserEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@FluentMybatis(table = "t_user", schema = "fluent-mybatis")
public class TUserEntity extends RichEntity {

  private static final long serialVersionUID = 1L;

  /**
   * 主键
   */
  @TableId(value = "id", auto = true)
  private Long id;

  /**
   * 姓名
   */
  @TableField("name")
  private String name;

  /**
   * 年龄
   */
  @TableField("age")
  private Integer age;

  /**
   * 邮箱
   */
  @TableField("email")
  private String email;

  /**
   * 直属上级id
   */
  @TableField("manager_id")
  private Long managerId;

  /**
   * 创建时间
   */
  @TableField(value = "create_time", insert = "now()")
  private Date createTime;

  /**
   * 更新时间
   */
  @TableField(value = "update_time", insert = "now()", update = "now()")
  private Date updateTime;

  /**
   * 逻辑删除
   */
  @TableField(value = "is_deleted", insert = "0")
  @LogicDelete
  private Boolean isDeleted;

  @Override
  public final Class entityClass() {
    return TUserEntity.class;
  }

}
