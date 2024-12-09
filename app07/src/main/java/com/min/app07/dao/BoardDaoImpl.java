package com.min.app07.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.app07.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class BoardDaoImpl implements IBoardDao {

  private final SqlSessionTemplate template;
  
 
  /* 
   ** @RequiredArgsConstructor **
    public BoardDaoImpl(@NonNull SqlSessionTemplate template) {
    this.template = template;
  }
  */
  
  @Override
  public List<BoardDto> selectBoardList() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int selectBoardCount() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public BoardDto selectBoardById(int boardId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int insertBoard(BoardDto boardDto) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int updateBoard(BoardDto boardDto) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteBoard(BoardDto boardDto) {
    // TODO Auto-generated method stub
    return 0;
  }

}
