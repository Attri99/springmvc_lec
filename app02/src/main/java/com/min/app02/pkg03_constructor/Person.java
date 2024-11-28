package com.min.app02.pkg03_constructor;

import org.springframework.stereotype.Component;

import com.min.app02.domain.Address;
import com.min.app02.domain.Contact;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*
 * DI 방식 3 - Constructor 주입
 * Spring Container 에 있는 bean을 Constructor의 매개변수에 주입(전달)하는 방식이다.
 * 생성자에 @Autowired를 한 번만 추가하면 된다. 
 * Spring Framework 4.3 이후 버전부터는 @Autowired는 생략할 수 있다.
 * 생성자 주입을 이용하면 필드에 final 키워드를 추가하여 좀 더 안전한 코드를 작성할 수 있다.
 * final 키워드가 추가된 필드의 초기화를 위한 생성자는 @AllArgsConstructor 가 아니다.
 * field에 final 키워드를 추가한 뒤 @RequiredArgsConstructor 를 사용한다.
 * 
 */
@RequiredArgsConstructor

@Component

//@AllArgsConstructor // Person(Address, Contact)

@ToString
public class Person {

  // field
  private final Address address;
  private final Contact contact;

  // constructor
  // @Autowired 생성자 주입의 경우에만 생략 가능
 /* public Person(Address address, Contact contact) {
    this.address = address;
    this.contact = contact;
  } */
  
}
