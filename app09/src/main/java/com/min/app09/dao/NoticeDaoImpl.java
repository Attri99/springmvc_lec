package com.min.app09.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.min.app09.dto.AttachDto;
import com.min.app09.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository // service가 가져다 쓸 수 있도록 bean을 생성하는 annotation
public class NoticeDaoImpl implements INoticeDao {

  private final SqlSessionTemplate template;
  
  @Override
  public List<NoticeDto> selectNoticeList() {
    
    return template.selectList("mybatis.mappers.noticeMapper.selectNoticeList");
  }

  @Override
  public NoticeDto selectNoticeById(int noticeId) {
    return template.selectOne("mybatis.mappers.noticeMapper.selectNoticeById", noticeId);
  }

  @Override
  public List<AttachDto> selectAttachListByNoticeId(int noticeId) {
    
    return template.selectList("mybatis.mappers.noticeMapper.selectAttachListByNoticeId", noticeId);
  }

  @Override
  public AttachDto selectAttachById(int attachId) {
    
    return template.selectOne("mybatis.mappers.noticeMapper.selectAttachById", attachId);
  }
  
  @Override
  public int insertNotice(NoticeDto noticeDto) {
    
    return template.insert("mybatis.mappers.noticeMapper.insertNotice", noticeDto);
  }

  @Override
  public int insertAttach(AttachDto attachDto) {
    // TODO Auto-generated method stub
    return template.insert("mybatis.mappers.noticeMapper.insertAttach", attachDto);
  }

  @Override
  public int deleteNotice(int noticeId) {
    // TODO Auto-generated method stub
    return template.delete("mybatis.mappers.noticeMapper.deleteNotice", noticeId);
  }
  
  @Override
  public int updateAttachDownloadCount(int attachId) {
    return template.update("mybatis.mappers.noticeMapper.updateAttachDownloadCount", attachId);
  }
}
