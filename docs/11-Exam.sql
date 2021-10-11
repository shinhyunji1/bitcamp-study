### 3. 실습 - where 조건절 활용

CREATE TABLE EMPLOYEE
(
	EMP_ID CHAR(5) PRIMARY KEY NOT NULL,
	GRADE CHAR(10) NOT NULL,
	NM CHAR(10),
	TEL_NO CHAR(20)
);

INSERT INTO EMPLOYEE VALUES ('15501', '8', 'YK MO', '5740');
INSERT INTO EMPLOYEE VALUES ('15687', '8', 'SS CHANG', '5547');
INSERT INTO EMPLOYEE VALUES ('16780', '5', 'HY YOO', '2327');
INSERT INTO EMPLOYEE VALUES ('63278', '7', 'JW PARK', '2304');
INSERT INTO EMPLOYEE VALUES ('87871', '7', 'SW HONG', '2367');
INSERT INTO EMPLOYEE VALUES ('23578', '6', 'JI CHOI', '4654');
INSERT INTO EMPLOYEE VALUES ('32480', '6', 'JM CHA', '1270');
INSERT INTO EMPLOYEE VALUES ('23480', '5', 'KE LEE', '5466');

delete from employee
    -> where emp_id in ('32480', '23480');

update employee
set tel_no = 5800
where emp_id in ('15501');