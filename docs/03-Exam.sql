### 3. 실습 - select문에서 많이 사용되는 키워드

CREATE TABLE EMP
(
	ID CHAR(3) PRIMARY KEY NOT NULL,
	POSITION CHAR(10) NOT NULL,
	PARTY_NM CHAR(10) NOT NULL,
	MANAGER_ID CHAR(10) NOT NULL,
	TEAM_NM CHAR(10) NOT NULL,
	GRADE CHAR(10) NOT NULL
);

INSERT INTO EMP VALUES ('650', '대리', '이재훈', '1270', '마케팅부', '1');
INSERT INTO EMP VALUES ('540', '과장', '장성수', '3221', '리스크부', '2');
INSERT INTO EMP VALUES ('210', '차장', '문보미', '3914', '인사팀', '3');
INSERT INTO EMP VALUES ('347', '차장', '정호천', '3942', '기획팀', '3');
INSERT INTO EMP VALUES ('970', '부장', '김영성', '3221', '리스크부', '2');
INSERT INTO EMP VALUES ('345', '대리', '오윤경', '1270', '마케팅부', '2');
INSERT INTO EMP VALUES ('711', '과장', '이재중', '3914', '인사팀', '2');

-- 인사고과를 주는 사람들 구하기
select distinct MANAGER_ID from emp;

-- 인사고과를 몇명이 주고 있는지 구하기
select count(distinct manager_id) from emp;

-- 별칭 사용해서 인사고과를 몇 명이 주고 있는지 구하기
select count(distinct manager_id) as cnt from emp;

-- 인용부호("") 사용하기
select count(distinct manager_id) "cnt" from emp;