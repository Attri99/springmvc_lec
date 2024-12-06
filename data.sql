DROP DATABASE IF EXISTS db_myapp;
CREATE DATABASE IF NOT EXISTS db_myapp;

USE db_myapp;
DROP TABLE IF EXISTS tbl_blog;
CREATE TABLE IF NOT EXISTS tbl_blog
(
	blog_id    INT AUTO_INCREMENT COMMENT '블로그',
  title 		 VARCHAR(1000) NOT NULL COMMENT '제목',
  content    TEXT COMMENT '내용',
	user_email VARCHAR(100) NOT NULL COMMENT '작성자 이메일',
	hit			   INT COMMENT '조회수',
  modify_dt  DATETIME COMMENT '수정일',
  create_dt  DATETIME COMMENT '작성일',
  CONSTRAINT pk_blog PRIMARY KEY (blog_id)
) ENGINE=INNODB COMMENT '블로그';