package com.github.weichun97;

import com.github.weichun97.generate.autoconfigure.annotations.EnableGenerate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableGenerate
@SpringBootApplication
@MapperScan("com.github.weichun97.mapper")
public class ScreenApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScreenApplication.class, args);
    }

}
