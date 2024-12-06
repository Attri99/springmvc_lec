package com.min.myapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.min.myapp.dao.IBlogDao;

@SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BlogDaoTest {

  @Autowired
  private IBlogDao blogDao;
  
  @Test
  void 목록테스트 () {
    
    assertEquals(2, blogDao.selectBlogList().size());
  }
  
  @Test
  void 상세테스트 () {
    
    int blog_id = 2;
    assertEquals("표고버섯구이", blogDao.selectBlogById(blog_id).getTitle());
  }
  
  
}
