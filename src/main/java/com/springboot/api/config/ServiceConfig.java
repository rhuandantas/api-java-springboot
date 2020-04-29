package com.springboot.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.springboot.api.service" })
public class ServiceConfig {

}
