package com.pk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.pk.manager","com.pk.service"})
public class ServiceConfig {
 
}
