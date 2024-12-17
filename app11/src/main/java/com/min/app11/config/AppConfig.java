package com.min.app11.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.min.app11.aop.AroundAdvice;
import com.min.app11.aop.BeforeAdvice;

//@EnableAspectJAutoProxy // AOP 동작을 위해서 필요합니다.
@Configuration // Spring Container에 bean을 만들어 두는 클래스입니다.
public class AppConfig {
  
  @Bean
  BeforeAdvice before() {
    return new BeforeAdvice();
  }
  
  @Bean
  AroundAdvice around() {
    return new AroundAdvice();
  }
}
