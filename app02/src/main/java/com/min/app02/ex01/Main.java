package com.min.app02.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class Main {

  public static void main(String[] args) {
    
    //AnnotationConfigApplicationContext
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.min.app02.ex01");
    
    Calculator calculator = ctx.getBean("calculator", Calculator.class);    
    System.out.println(calculator);
    
    ctx.close();
  }

}
