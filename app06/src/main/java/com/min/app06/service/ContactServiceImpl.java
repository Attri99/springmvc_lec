package com.min.app06.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.app06.dao.IContactDao;
import com.min.app06.dto.ContactDto;

@Service // 서비스가 사용하는 @Component입니다.
         // 비즈니스 계층(Business Layer)에서 사용한다.

public class ContactServiceImpl implements IContactService{

  @Autowired
  private IContactDao contactDao;
  
  @Override
  public Map<String, Object> getAllContact() {
    // Dao로부터 연락처 목록을 가져온다.
    Map<String, Object> contacts = contactDao.getContactList();
    // 전체 연락처 개수를 가져온다.
    int count = contactDao.getContactCount();
    // 연락처 목록과 전체 연락처 개수를 반환한다.
    return Map.of("contacts", contacts, "count", count);
  }

  @Override
  public ContactDto getContact(int contact_id) {
    // 연락처 정보를 Dao로부터 가져옵니다.
    ContactDto contactDto = contactDao.getContactById(contact_id);
    // 가져온 연락처 정보를 반환합니다.
    return contactDto;
  }

  @Override
  public String register(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String modify(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String remove(HttpServletRequest request) {
    // TODO Auto-generated method stub
    return null;
  }
  
  
}
