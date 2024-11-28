package com.min.app01.pkg02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 나는 bean을 만드는 클래스입니다.
public class AppConfig {
  
  /* 메소드 == bean */
  /*
   * 반환타입 : bean의 타입. <bean class="">  
   * 메소드명 : bean의 이름. <bean id="">
   * 
   */
  
  @Bean // 나는 bean을 만드는 메소드입니다.
  public Contact contact() {
    Contact contact = new Contact();
    contact.setMobile("010-1111-1111");
    contact.setEmail("user@min.com");
    return contact;
  }

  @Bean(name = "person") // bean의 이름은 person 입니다.
  Person person() {      // 메소드 이름은 더 이상 bean의 이름이 아닙니다. 
    Person person = new Person();
    person.setName("유저");
    person.setContact(contact());
    return person;
  }
}
