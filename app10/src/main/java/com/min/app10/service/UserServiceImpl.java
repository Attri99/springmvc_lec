package com.min.app10.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.min.app10.dao.IUserDao;
import com.min.app10.dto.UserDto;
import com.min.app10.util.PageUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService {

  private final IUserDao userDao;
  private final PageUtil pageUtil;
  @Override
  public Map<String, Object> getUserList(HttpServletRequest request) {
    
    // page 파라미터 (디폴트 1)
    
   Optional<String> optPage = Optional.ofNullable(request.getParameter("page"));
   int page = Integer.parseInt(optPage.orElse("1"));
   
   // display 파라미터 (디폴트 20)
   Optional<String> optDisplay = Optional.ofNullable(request.getParameter("display"));
   int display = Integer.parseInt(optDisplay.orElse("20"));
   
   // off set 계산하기
   pageUtil.setPaging(page, display);
   
   // sort 파라미터 (디폴트 DESC)
   Optional<String> optSort = Optional.ofNullable(request.getParameter("sort"));
   String sort = optSort.orElse("DESC");
   
   // 목록 가져오기
   List<UserDto> users = userDao.selectUserList(Map.of("offset", pageUtil.getOffset(), "display", pageUtil.getDisplay(),
                                                       "sort", sort));
   // 결과 반환하기
   return Map.of("users", users);
    
  }
}
