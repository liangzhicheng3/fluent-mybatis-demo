package com.liangzhicheng.config.db;

import cn.org.atool.fluent.mybatis.spring.MapperFactory;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@MapperScan("com.liangzhicheng.modules.mapper")
@Configuration
public class FluentMybatisConfig {

//    /**
//     * mapper的xml位置
//     */
//    public static final String[] DATASOURCE_MAPPER_LOACTIONS = {"classpath*:com/liangzhicheng/**/*Mapper.xml"};
//
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(this.getMapperResource());
//        return bean.getObject();
//    }

    @Bean
    public MapperFactory mapperFactory() {
        return new MapperFactory();
    }

//    /**
//     * @description mapper的xml路径处理，把String[]转Resource[]
//     * @return Resource[]
//     */
//    private Resource[] getMapperResource(){
//        try {
//            if(DATASOURCE_MAPPER_LOACTIONS != null && DATASOURCE_MAPPER_LOACTIONS.length > 0) {
//                List<Resource> resourceList = new ArrayList<>();
//                for (String location : DATASOURCE_MAPPER_LOACTIONS) {
//                    Resource[] resourceArr = new Resource[0];
//                    resourceArr = new PathMatchingResourcePatternResolver().getResources(location);
//                    for (Resource resource : resourceArr) {
//                        resourceList.add(resource);
//                    }
//                }
//                Resource[] resources = new Resource[resourceList.size()];
//                for (int i = 0; i < resourceList.size(); i++) {
//                    resources[i] = resourceList.get(i);
//                }
//                return resources;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}
