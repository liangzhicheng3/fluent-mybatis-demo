package com.liangzhicheng;

import com.liangzhicheng.common.page.PageResult;
import com.liangzhicheng.modules.dao.impl.TUserDaoImpl;
import com.liangzhicheng.modules.dao.intf.TUserDao;
import com.liangzhicheng.modules.entity.TUserEntity;
import com.liangzhicheng.modules.wrapper.TUserQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MybatisDemo {

    @Resource
    private TUserDao userDao;

    @Test
    public void save(){
        TUserEntity user = new TUserEntity()
                .setName("梁董事").setAge(18).setEmail("yichengc3@163.com");
        userDao.save(user);
        System.out.println(user);
    }

    @Test
    public void delete(){
        userDao.deleteById(6L);
    }

    @Test
    public void update(){
        TUserEntity user = userDao.selectById(6L);
        user.setName("梁老板").setAge(19).setEmail("501802249@qq.com");
        userDao.updateById(user);
        System.out.println(user);
    }

    @Test
    public void list(){
        List<TUserEntity> userList = userDao.selectList();
        System.out.println(userList);
    }

    @Test
    public void page1(){
        PageResult<TUserEntity> result = userDao.selectPage1();
        System.out.println(result);
    }

    @Test
    public void page2(){
        PageResult<TUserEntity> result = userDao.selectPage2();
        System.out.println(result);
    }

    @Test
    public void select_in(){
        List<TUserEntity> userList = userDao.select_in();
        System.out.println(userList);
    }

    @Test
    public void select_exists(){
        List<TUserEntity> userList = userDao.select_exists();
        System.out.println(userList);
    }

    @Test
    public void select_join(){
        List<TUserEntity> userList = userDao.select_join();
        System.out.println(userList);
    }

}
