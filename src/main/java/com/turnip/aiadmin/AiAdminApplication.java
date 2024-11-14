package com.turnip.aiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
@MapperScan("com.turnip.aiadmin.mapper")
public class AiAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiAdminApplication.class, args);
    }

}
