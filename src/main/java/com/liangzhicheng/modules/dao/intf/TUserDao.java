package com.liangzhicheng.modules.dao.intf;

import cn.org.atool.fluent.mybatis.base.IBaseDao;
import com.liangzhicheng.common.page.PageResult;
import com.liangzhicheng.modules.entity.TUserEntity;

import java.util.List;
import java.util.Map;

public interface TUserDao extends IBaseDao<TUserEntity> {

    List<TUserEntity> selectList();

    PageResult<TUserEntity> selectPage1();

    PageResult<TUserEntity> selectPage2();

    List<TUserEntity> select_in();

    List<TUserEntity> select_exists();

    List<TUserEntity> select_join();

}
