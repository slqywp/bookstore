package com.xuhuang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ApplicationStarter
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
