package com.instakilogram.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.instakilogram.api.dao",  "com.instakilogram.api.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}