package com.min.app07.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IBoardService {

  Map<String, Object> getBoardList(HttpServletRequest request);

  
  
}
