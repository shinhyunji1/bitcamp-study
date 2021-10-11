### 3. 실습 - where 조건절 활용

CREATE TABLE CARD_TRAN_201311
(
	CMF CHAR(4) PRIMARY KEY NOT NULL,
	PARTY_NM CHAR(10) NOT NULL,
	SEG CHAR(10) NOT NULL,
	PIF_AMT DECIMAL(15,0),
	INST_AMT DECIMAL(15,0),
	OVRS_AMT DECIMAL(15,0),
	CASH_AMT DECIMAL(15,0)
);

INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT, OVRS_AMT) VALUES ('2356', '김아름', 'PB', 1234041, 1301710,);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, OVRS_AMT) VALUES ('4570', '이선우', 'MASS', 524560);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT, CASH_AMT) VALUES ('4563', '홍지은', 'MASS', 213570, 3700000);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT, INST_AMT) VALUES ('3266', '윤일상', 'MASS', 89641);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT, INST_AMT) VALUES ('8904', '이동건', 'PB', 1278960, 500000);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT) VALUES ('4678', '최혜연', 'MASS', 4567780);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT, INST_AMT) VALUES ('1746', '임하영', 'PB', 7836100, 3213400);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG) VALUES ('3120', '김지철', 'PB' );
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT) VALUES ('8974', '강성범', 'MASS', 655456 );
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT) VALUES ('3255', '김지연', 'MASS', 213);
INSERT INTO CARD_TRAN_201311(CMF, PARTY_NM, SEG, PIF_AMT, OVRS_AMT, CASH_AMT) VALUES ('8977', '김지현', 'PB', 1300, 54000, 100000);

1. 고객별 총 사용금액을 기준으로 내림차순하기
select cmf, party_nm,
(coalesce(pif_amt, 0) + coalesce(INST_AMT, 0) + coalesce(OVRS_AMT, 0) + coalesce(CASH_AMT, 0))
as tot_amt
from CARD_TRAN_201311
order by 3 desc;

2. 고객 중 신용카드 사용 한 사람 구하기
select cmf, party_nm, INST_AMT
from CARD_TRAN_201311
where INST_AMT > 0;

3. 어떤 고객들 대상으로 일시불 사용금액의 10%를 캐시백주기
select cmf, party_nm, seg, pif_amt, pif_amt * 0.1
as reward_amt
from CARD_TRAN_201311
where seg = 'PB';