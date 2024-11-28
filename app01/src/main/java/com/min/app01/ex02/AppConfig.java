package com.min.app01.ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  Adder adder() {
    return new Adder();
  }
  
  @Bean
  public Calculator calc() {
    Calculator calc = new Calculator();
    calc.setBrand("샤프");
    calc.setModule1(adder());
    return calc;
    
  }
}
