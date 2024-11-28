package com.min.app01.ex02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    
    //GenericXMLApplicationContext
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("ex01/appCtx.xml");
    
    Calculator calculator1 = ctx.getBean("calc1", Calculator.class);
    System.out.println(calculator1.getBrand());
    System.out.println(calculator1.getModule1().add(1,2,3,4,5));
    System.out.println(calculator1.getModule2().subtract(10, 2));
    System.out.println(calculator1.getModule3().multiply(1,2,3,4,5));
    System.out.println(calculator1.getModule4().divide(5, 2));
   
    
    ctx.close();
  }

}
