package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author cyf
 */
@SpringBootApplication
// 引用外部配置文件
@PropertySource(value = {"file:config/application.properties","file:config/jdbc.properties"},encoding = "UTF-8")
@EnableTransactionManagement
public class TransactionStart {
    private static final Logger log = LoggerFactory.getLogger(TransactionStart.class);

    public static void main(String[] args) {
        SpringApplication.run(TransactionStart.class, args);
        log.info("========================启动完毕========================");
    }
}
