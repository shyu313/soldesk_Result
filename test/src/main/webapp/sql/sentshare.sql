create table sentshare(
bbsno NUMBER(7) not null -- 글번호
,wname VARCHAR2(30) not null -- 작성자
,subject VARCHAR2(1000) not null -- 제목
,content VARCHAR2(4000) not null -- 글내용
,readcnt NUMBER(12) DEFAULT 0 not null -- 조회수 
,regdt date default SYSDATE -- 등록일
,primary key(bbsno)
);

create sequence bbsno_seq

drop table sentshare purge;

select * from sentshare;

SELECT bbsno, subject, wname, readcnt, regdt FROM sentshare ORDER BY bbsno DESC