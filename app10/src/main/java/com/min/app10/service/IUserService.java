package com.min.app10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
 
  public Map<String, Object> getUserList(HttpServletRequest request);
}
