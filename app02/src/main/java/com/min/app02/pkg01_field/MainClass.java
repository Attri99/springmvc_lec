package com.min.app02.pkg01_field;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.min.app02.domain.Address;

public class MainClass {
  
  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new AnnotationConfigApplicationContext("com.min.app02.pkg01_field", "com.min.app02.domain"); // AnnotationConfigApplicationContext("com.min.app02");
    
    Person person = ctx.getBean("person", Person.class);
    System.out.println(person);
    
    Address address = ctx.getBean(Address.class);
    System.out.println(address);
    ctx.close();
  }
}