package com.liangzhicheng.modules.dao.impl;

import cn.org.atool.fluent.mybatis.If;
import cn.org.atool.fluent.mybatis.base.crud.IQuery;
import cn.org.atool.fluent.mybatis.base.crud.JoinBuilder;
import cn.org.atool.fluent.mybatis.base.crud.JoinToBuilder;
import cn.org.atool.fluent.mybatis.segment.JoinQuery;
import com.liangzhicheng.common.page.PageResult;
import com.liangzhicheng.modules.dao.base.TUserBaseDao;
import com.liangzhicheng.modules.dao.intf.TUserDao;
import com.liangzhicheng.modules.entity.TUserEntity;
import com.liangzhicheng.modules.wrapper.TUserQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TUserDaoImpl extends TUserBaseDao implements TUserDao {

    @Override
    public List<TUserEntity> selectList() {
        return super.listEntity(TUserQuery.query());
    }

    @Override
    public PageResult<TUserEntity> selectPage1() {
        int pageNo = 0, pageSize = 2;
        TUserQuery query = TUserQuery.query().where.age().eq(39).end().limit(pageNo, pageSize);
        int count = super.count(query);
        List<TUserEntity> list = super.listEntity(query);
        return new PageResult<>(pageNo, pageSize, list, count);
    }

    @Override
    public PageResult<TUserEntity> selectPage2() {
        String name = "C";
        int pageNo = 0, pageSize = 2;
        TUserQuery query = TUserQuery.query().where.name().like(name, If::notBlank).end().limit(pageNo, pageSize);
        int count = super.count(query);
        List<TUserEntity> list = super.listEntity(query);
        return new PageResult<>(pageNo, pageSize, list, count);
    }

    @Override
    public List<TUserEntity> select_in() {
        TUserQuery query = new TUserQuery()
                .where.isDeleted().isFalse()
                .and.age().eq(40)
                .and.id().in(new TUserQuery()
                        .selectId()
                        .where.isDeleted().isFalse()
                        .and.managerId().eq(2L)
                        .end()
                ).end();
        return super.listEntity(query);
    }

    @Override
    public List<TUserEntity> select_exists() {
        TUserQuery query = new TUserQuery()
                .where.isDeleted().isFalse()
                .and.age().eq(40)
                .and.managerId().eq(2L)
                .and.exists(new TUserQuery()
                        .selectId()
                        .where.isDeleted().isFalse()
                        .end()
                ).end();
        return super.listEntity(query);
    }

    @Override
    public List<TUserEntity> select_join() {
        IQuery query = JoinBuilder
                .from(
                        new TUserQuery("t1")
                                .select.name().end()
                                .where.managerId().eq(2L)
                                .end()
                )
                .leftJoin(
                        new TUserQuery("t2")
                )
                .on(u1 -> u1.where.id(), u2 -> u2.where.managerId()).endJoin()
//                .join(
//
//                )
                .build();
        System.out.println(query);
        return super.listEntity(query);
    }

}
