package org.structure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy
@ComponentScans(value = {@ComponentScan("design.door"),@ComponentScan("org.structure")})
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);
    }
}