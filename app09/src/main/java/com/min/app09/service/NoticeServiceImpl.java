package com.min.app09.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.min.app09.dao.INoticeDao;
import com.min.app09.dto.AttachDto;
import com.min.app09.dto.NoticeDto;
import com.min.app09.util.FileUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service // 컨트롤러가 service를 사용할수 있도록 붙여줌
public class NoticeServiceImpl implements INoticeService {

  private final FileUtil fileUtil;
  private final INoticeDao noticeDao;

  @Override
  public List<NoticeDto> getNoticeList() {
    
    return noticeDao.selectNoticeList();
  }
  
  @Override
  public String registNotice(MultipartHttpServletRequest multipartRequest) {
    // 공지사항 제목과 내용
    String noticeTitle = multipartRequest.getParameter("noticeTitle");
    String noticeContents = multipartRequest.getParameter("noticeContents");
    
    NoticeDto noticeDto = NoticeDto.builder()
                                  .noticeTitle(noticeTitle)
                                  .noticeContents(noticeContents)
                                  .build();
    
    // DB에 공지사항 등록하기
    int result = noticeDao.insertNotice(noticeDto); // 매퍼의 <selectKey>에 의해서 noticeDto의 noticeId 필드에 값이 채워집니다.
    if(result == 0)
      return "공지사항 등록 실패";
    
    // 첨부 파일 목록 받기
    List<MultipartFile> files = multipartRequest.getFiles("files");
    for(MultipartFile multipartFile : files) {
      
      // 첨부 파일 존재 여부 확인
      if(!multipartFile.isEmpty()) {
        
        // 첨부 파일의 원래 이름
        String originalFilename = multipartFile.getOriginalFilename();
        
        // 첨부 파일의 저장 이름
        String filesystemName = fileUtil.getFilesystemName(originalFilename);
        
        // 첨부 파일의 저장 경로
        String filePath = fileUtil.getFilePath();
        File dir = new File(filePath);
        if(!dir.exists())
          dir.mkdirs();
        
        // 첨부 파일을 HDD에 저장
        try {
          multipartFile.transferTo(new File(dir,filesystemName));
        } catch (Exception e) {
          e.printStackTrace();
        }
        
        // 첨부 파일 정보를 DB에 저장
        AttachDto attachDto = AttachDto.builder()
                                      .noticeId(noticeDto.getNoticeId())
                                      .filePath(filePath)
                                      .originalFilename(originalFilename)
                                      .filesystemName(filesystemName)
                                      .build();
        int attachResult = noticeDao.insertAttach(attachDto);
        if(attachResult == 0)
          return "첨부 파일 등록 실패";
      
      }
      
    }
      return "공지사항 등록 성공";
  }
  
  @Override
  public Map<String, Object> getNoticeById(int noticeId) {
    
    return Map.of("n", noticeDao.selectNoticeById(noticeId)
                , "attachList", noticeDao.selectAttachListByNoticeId(noticeId));
  }

}
