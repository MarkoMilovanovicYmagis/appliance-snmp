package com.ymagis.emulator.appliancesnmp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApplianceSnmpApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplianceSnmpApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplianceSnmpApplication.class, args);
    }

}
