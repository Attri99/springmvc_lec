package com.min.app02.pkg01_field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.app02.domain.Address;
import com.min.app02.domain.Contact;

import lombok.ToString;

/*
 * DI 방식 1 - 필드 주입
 * Spring Container 에 있는 bean을 필드에 주입(전달)하는 방식
 * 필드마다 @Autowired 를 추가하면 된다.
 */

@Component // Spring Container에 person 이라는 이름의 bean이 만들어진다.
@ToString // Person 타입의 bean을 System.out.println() 으로 곧바로 확인 가능해짐

public class Person {
  
  //field
  
  @Autowired // Spring Container에서 타입이 Address인 bean을 가져옵니다.
  private Address address;
  
  
  @Autowired // Spring Container에서 타입이 Contact인 bean을 가져옵니다.
  private Contact contact;
  
  
}
