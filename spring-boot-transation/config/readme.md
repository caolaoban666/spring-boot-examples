#功能
springboot mybatis-plus 整合事物

#约定
- 文件编码UTF-8
- 编译环境JDK1.8

- springboot1.5.18
- mybatis plus2.2.0

#使用方法说明
- 修改jdbc.properties 数据库连接信息
- 初始化init.sql
- run start

#注意事项 


# 技术使用

- 配置 DataSource  DataSourceTransactionManager 
- 开启事物 @EnableTransactionManagement
- service 方法上开启事物  
    -- 方法须 public 修饰
    -- 方法须 抛出异常 不能处理
    -- 方法添加注解 @Transactional(rollbackFor = RuntimeException.class)

#问题排查
- 

#已知问题


