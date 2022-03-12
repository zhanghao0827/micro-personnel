package com.easyhao.micro.personnel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.easyhao.micro.personnel.mapper")
@EnableScheduling
public class MicroPersonnelApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroPersonnelApplication.class, args);
    }

}
