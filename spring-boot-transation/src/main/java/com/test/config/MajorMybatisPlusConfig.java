package com.test.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = MajorMybatisPlusConfig.PACKAGE,sqlSessionFactoryRef="majorSqlSessionFactory")
public class MajorMybatisPlusConfig {
    static final String PACKAGE="com.test.mapper.master";
    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";


    @Value("${db.master.url}")
    private String url;

    @Value("${db.master.user}")
    private String user;

    @Value("${db.master.password}")
    private String password;

    @Value("${db.master.driver}")
    private String driverClass;


    @Bean("majorDataSource")
    @Primary
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url.trim());
        dataSource.setDriverClassName(driverClass.trim());
        dataSource.setUsername(user.trim());
        dataSource.setPassword(password.trim());
        return dataSource;
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean("majorSqlSessionFactory")
    @Primary
    public SqlSessionFactory majorSqlSessionFactory(ResourceLoader resourceLoader) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource());
        sqlSessionFactory.setTypeAliasesPackage("com.test.entity.major");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MajorMybatisPlusConfig.MAPPER_LOCATION));
        sqlSessionFactory.setConfigLocation(resourceLoader.getResource("classpath:mybatis-config.xml"));
        sqlSessionFactory.setPlugins(new Interceptor[]{
                new PaginationInterceptor(),
                new PerformanceInterceptor()
//                new MybatisInterceptor()
        });
//        sqlSessionFactory.setGlobalConfig(globalConfiguration);
        return sqlSessionFactory.getObject();
    }
}
