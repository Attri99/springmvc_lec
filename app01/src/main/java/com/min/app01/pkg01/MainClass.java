package com.min.app01.pkg01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

  public static void main(String[] args) {
    
    // GenericXmlApplicationContext 클래스
    // XML로 생성된 bean을 관리하는 클래스
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("pkg01/app-context.xml");
    
    Contact c = ctx.getBean("contact", Contact.class); // Contact c = (Contact)
    System.out.println(c.getMobile());
    System.out.println(c.getEmail());
    
    Person p = ctx.getBean("personBean", Person.class);
   
    // scope 동작 확인
    Person p2 = ctx.getBean("personBean", Person.class);
    System.out.println(p == p2);
    ctx.close();
    
    // Singleton pattern 확인
    /* Contact c1 = Contact.getInstance();
    Contact c2 = Contact.getInstance();
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c1 == c2);
    */
    
  }

}
