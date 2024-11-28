package com.min.app01.ex01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    
    //GenericXMLApplicationContext
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("ex01/appCtx.xml");
    
    Calculator calculator1 = ctx.getBean("calc1", Calculator.class);
    System.out.println(calculator1.getBrand());
    System.out.println(calculator1.getModule1().add(1,2,3,4,5));
    System.out.println(calculator1.getModule2().subtract(10, 2));
    System.out.println(calculator1.getModule3().multiply(1,2,3,4,5));
    System.out.println(calculator1.getModule4().divide(5, 2));
   
    Calculator calculator2 = ctx.getBean("calc2", Calculator.class);
    System.out.println(calculator2.getBrand());
    System.out.println(calculator2.getModule1().add(1,2,3,4,5));
    System.out.println(calculator2.getModule2().subtract(10, 2));
    System.out.println(calculator2.getModule3().multiply(1,2,3,4,5));
    System.out.println(calculator2.getModule4().divide(5, 2));
    
    ctx.close();
  }

}
