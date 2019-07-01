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
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = ScientPerMybatisPlusConfig.PACKAGE,sqlSessionFactoryRef="scientSqlSessionFactory")
public class ScientPerMybatisPlusConfig {
    static final String PACKAGE="com.test.mapper.scient";
    static final String MAPPER_LOCATION = "classpath*:mapper/scient/*.xml";


    @Value("${db.scient_per.url}")
    private String url;

    @Value("${db.scient_per.user}")
    private String user;

    @Value("${db.scient_per.password}")
    private String password;

    @Value("${db.scient_per.driver}")
    private String driverClass;


    @Bean("scientDataSource")
    public DataSource scientDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url.trim());
        dataSource.setDriverClassName(driverClass.trim());
        dataSource.setUsername(user.trim());
        dataSource.setPassword(password.trim());
        return dataSource;
    }

    @Bean("scientTransactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(scientDataSource());
    }

    @Bean(value = "scientSqlSessionFactory")
    public SqlSessionFactory scientSqlSessionFactory(ResourceLoader resourceLoader) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(scientDataSource());
        sqlSessionFactory.setTypeAliasesPackage("com.test.entity.scient");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ScientPerMybatisPlusConfig.MAPPER_LOCATION));
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
