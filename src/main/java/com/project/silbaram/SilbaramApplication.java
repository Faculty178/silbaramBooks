package com.project.silbaram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//!!!!!!mapperscan에 basePackages 지정 필수, DAO 패키지와 동일하게 지정하기!!!!!
@MapperScan(basePackages = "com.project.silbaram.dao")
@SpringBootApplication
public class SilbaramApplication {

    public static void main(String[] args) {
        SpringApplication.run(SilbaramApplication.class, args);
    }

}
