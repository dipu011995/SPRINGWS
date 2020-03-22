package com.pk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.pk.service,com.pk.aspect")
@EnableAspectJAutoProxy
public class Appconfig {

}
