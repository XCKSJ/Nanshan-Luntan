package com.cque.nanshanluntan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cque.nanshanluntan.mapper")
public class NanshanLuntanApplication {

    public static void main(String[] args) {
        SpringApplication.run(NanshanLuntanApplication.class, args);
    }

}
