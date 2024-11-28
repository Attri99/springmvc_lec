package com.min.app01.ex03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

  public static void main(String[] args) {
    
    //AnnotationConfigApplicationContext
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.min.app01.ex03");
    
    Calculator calculator = ctx.getBean("calculator", Calculator.class);
    System.out.println(calculator.getBrand());
    System.out.println(calculator.getModule1().add(1,2,2,2,3,5));
    System.out.println(calculator.getModule2().subtract(2, 5));
    System.out.println(calculator.getModule3().multiply(4,5,6));
    System.out.println(calculator.getModule4().divide(2, 5));
    
    
    
    ctx.close();
  }

}