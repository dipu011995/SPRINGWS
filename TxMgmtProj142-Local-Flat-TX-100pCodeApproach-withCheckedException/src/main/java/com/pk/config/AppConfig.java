package com.pk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PersistanceConfig.class,ServiceConfig.class,AopConfig.class})
public class AppConfig {

}
