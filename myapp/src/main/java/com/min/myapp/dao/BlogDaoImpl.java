package com.min.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.min.myapp.dto.BlogDto;


@Repository
public class BlogDaoImpl implements IBlogDao{
  
  private Connection conn; 
  private PreparedStatement ps;
  private ResultSet rs;
  
  @Override
  public void connect() throws ClassNotFoundException, SQLException {
    
    
      String url = "jdbc:mysql://127.0.0.1:3306/db_myapp?serverTimezone=Asia/Seoul";
      String username = "greenit";
      String password = "greenit";
            
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(url, username, password);
      
    
  }
  
  @Override
  public void close() throws SQLException {
      if(conn != null) conn.close();
      if(ps != null) ps.close();
      if(rs != null) rs.close();
   } 
  
  
  @Override
  public List<BlogDto> selectBlogList() {
    // BlogDto에 저장된 data들을 list화하는 작업
    List <BlogDto> blogs = new ArrayList<BlogDto>();
    // 데이터베이스에 접속하기
    
    try {
      connect();
      String sql = "SELECT blog_id, title, content, user_email, hit, modify_dt, create_dt FROM tbl_blog ORDER BY blog_id DESC";
      
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        BlogDto blogDto = BlogDto.builder()
                              .blog_id(rs.getInt(1))
                              .title(rs.getString(2))
                              .content(rs.getString(3))
                              .user_email(rs.getString(4))
                              .hit(rs.getInt(5))
                              .modify_dt(rs.getTimestamp(6))
                              .create_dt(rs.getTimestamp(7))
                              .build();
       // 완성된 객체를 List에 저장
        blogs.add(blogDto);
      }
      close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return blogs;
  }

  @Override
  public BlogDto selectBlogById(int blog_id) {
    // 호출받는 blog_id를 가진 Blog를 찾아 반환한다.
    BlogDto blogDto = null;
    try {
      connect();
      String sql = "SELECT blog_id, title, content, user_email, hit, modify_dt, create_dt FROM tbl_blog WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id);
      rs = ps.executeQuery();
      while(rs.next()) {
           blogDto = BlogDto.builder() 
                     .blog_id(rs.getInt(1))
                     .title(rs.getString(2))
                     .content(rs.getString(3))
                     .user_email(rs.getString(4))
                     .hit(rs.getInt(5))
                     .modify_dt(rs.getTimestamp(6))
                     .create_dt(rs.getTimestamp(7))
                     .build();
      }      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return blogDto;
  }

  @Override
  public int selectBlogCount() {
    // 
    int count = 0;
    try {
     connect();
     String sql = "SELECT COUNT * FROM tbl_blog";
     ps = conn.prepareStatement(sql);
     rs = ps.executeQuery();
     if(rs.next()) {
       count = rs.getInt(1); // blog_id가 갯수와 같으므로
     }
     close();      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return count;
  }

  @Override
  public int insertBlog(BlogDto blogDto) {
    int result = 0;
    try {
      connect();
      String sql = "INSERT INTO tbl_blog VALUES (NULL, ?, ?, ?, 0, NULL, NOW())";
      ps=conn.prepareStatement(sql);
      ps.setString(1, blogDto.getTitle());
      ps.setString(2, blogDto.getContent());
      ps.setString(3, blogDto.getUser_email());
      result= ps.executeUpdate();   
    
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int updateBlog(BlogDto blogDto) {
    int result = 0;
    try {
      connect();
      String sql = "UPDATE tbl_blog SET title = ?, content = ?, modify_dt = NOW() WHERE blog_id = ?";
      ps=conn.prepareStatement(sql);
      ps.setString(1, blogDto.getTitle());
      ps.setString(2, blogDto.getContent());
      ps.setInt(3, blogDto.getBlog_id());
      result = ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public int deleteBlog(int blog_id) {
    int result = 0;
    try {
      connect();
      String sql = "DELETE FROM tbl_blog WHERE blog_id = ?";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id);
      result = ps.executeUpdate();
         
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
   }


  @Override
  public int updateHit(int blog_id) {
    int result = 0;
    try {
      connect();
      String sql = "UPDATE tbl_blog SET hit = hit + 1 WHERE blog_id = ? ";
      ps = conn.prepareStatement(sql);
      ps.setInt(1, blog_id);
      result = ps.executeUpdate();
          
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

   
  
}
