package com.min.app01.pkg01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
  private String mobile;
  private String email;

  /* singleton pattern : contact 인스턴스를 하나만 사용하는 패턴 */
  private static Contact contact = new Contact();
  private Contact() {
    
  } // 외부에서 생성하지 못하도록 설정
  public static Contact getInstance() {
    return contact;
  }

}
