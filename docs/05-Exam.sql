### 3. 실습 - where 조건절 활용

CREATE TABLE PERF_MAST
(
	CMF CHAR(4) PRIMARY KEY NOT NULL,
	PARTY_NM CHAR(10) NOT NULL,
	SEG CHAR(10) NOT NULL,
	TOT_AMT_1 DECIMAL(15,0) NOT NULL,
	TOT_AMT_2 DECIMAL(15,0) NOT NULL,
	TOT_AMT_3 DECIMAL(15,0) NOT NULL
);

INSERT INTO PERF_MAST VALUES ('2356', '김아름', 'PB', 790, 1770, 4780);
INSERT INTO PERF_MAST VALUES ('4570', '이선우', 'MASS', 90700, 5789, 87986);
INSERT INTO PERF_MAST VALUES ('4563', '홍지은', 'MASS', , , );
INSERT INTO PERF_MAST VALUES ('3268', '윤일상', 'MASS', 88805, 659860, 5130);
INSERT INTO PERF_MAST VALUES ('8904', '이동건', 'PB', 9846000, 5708900, 7600000);
INSERT INTO PERF_MAST VALUES ('4678', '최혜연', 'MASS', , 6000, );
INSERT INTO PERF_MAST VALUES ('1748', '임하영', 'PB', 1000400, 788000, 2378696);
INSERT INTO PERF_MAST VALUES ('3120', '김지철', 'PB', , , );
INSERT INTO PERF_MAST VALUES ('8974', '강성범', 'MASS', 540, , 7700);
INSERT INTO PERF_MAST VALUES ('3255', '김지연', 'MASS', 254860, 578321, 432004);
INSERT INTO PERF_MAST VALUES ('8977', '김지현', 'PB', 687063, 870000, 545400);