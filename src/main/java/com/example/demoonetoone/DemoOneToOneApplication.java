package com.example.demoonetoone;

import com.example.demoonetoone.service.CustomerService;
import com.example.demoonetoone.util.JPAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoOneToOneApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        SpringApplication.run(DemoOneToOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerService.createDB();
        JPAUtil.checkData("select * from Customer");
        JPAUtil.checkData("select * from Address");
    }
}
