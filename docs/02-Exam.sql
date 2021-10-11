### 2. 실습 - 테이블 생성, 여러개 column 생성하기

  MariaDB [studydb]> create table test1(
    ->   CUST_ID varchar(200) not null,
    ->   CUST_NM varchar(200) not null,
    ->   CUST_BIRTH datetime not null,
    ->   VIST_CNT int,
    ->   SALSE_AMT int,
    ->   SALSE_CNT int
    ->   );
Query OK, 0 rows affected (0.133 sec)

MariaDB [studydb]> insert into test1(CUST_ID, CUST_NM, CUST_BIRTH, VIST_CNT, SALSE_AMT, SALSE_CNT) values('56456','모형건','1982-01-24',123,3700000,24);
Query OK, 1 row affected (0.009 sec)

MariaDB [studydb]> insert into test1(CUST_ID, CUST_NM, CUST_BIRTH, VIST_CNT, SALSE_AMT, SALSE_CNT) values('65412','이상훈','1984-05-10',23,467200,14);
Query OK, 1 row affected (0.001 sec)

MariaDB [studydb]> insert into test1(CUST_ID, CUST_NM, CUST_BIRTH, VIST_CNT, SALSE_AMT, SALSE_CNT) values('23472','이상희','1978-02-27',117,2237065,23);
Query OK, 1 row affected (0.006 sec)

MariaDB [studydb]> insert into test1(CUST_ID, CUST_NM, CUST_BIRTH, VIST_CNT, SALSE_AMT, SALSE_CNT) values('27896','모영길','1982-05-11',37,123721,2);
Query OK, 1 row affected (0.015 sec)

MariaDB [studydb]> insert into test1(CUST_ID, CUST_NM, CUST_BIRTH, VIST_CNT, SALSE_AMT, SALSE_CNT) values('35478','강주혁','1983-09-10',86,830000,30);
Query OK, 1 row affected (0.001 sec)

MariaDB [studydb]> insert into test1(CUST_ID, CUST_NM, CUST_BIRTH, VIST_CNT, SALSE_AMT, SALSE_CNT) values('78693','이선우','1977-07-07',103,1789023,7);
Query OK, 1 row affected (0.006 sec)

MariaDB [studydb]> select * from test1;
+---------+-----------+---------------------+----------+-----------+-----------+
| CUST_ID | CUST_NM   | CUST_BIRTH          | VIST_CNT | SALSE_AMT | SALSE_CNT |
+---------+-----------+---------------------+----------+-----------+-----------+
| 56456   | 모형건    | 1982-01-24 00:00:00 |      123 |   3700000 |        24 |
| 65412   | 이상훈    | 1984-05-10 00:00:00 |       23 |    467200 |        14 |
| 23472   | 이상희    | 1978-02-27 00:00:00 |      117 |   2237065 |        23 |
| 27896   | 모영길    | 1982-05-11 00:00:00 |       37 |    123721 |         2 |
| 35478   | 강주혁    | 1983-09-10 00:00:00 |       86 |    830000 |        30 |
| 78693   | 이선우    | 1977-07-07 00:00:00 |      103 |   1789023 |         7 |
+---------+-----------+---------------------+----------+-----------+-----------+
6 rows in set (0.011 sec)

### 2. 실습 - 데이터 정렬하기 (오름차순, 내림차순)

MariaDB [studydb]> select CUST_ID,CUST_BIRTH,VIST_CNT from test1 order by CUST_BIRTH asc;
+---------+---------------------+----------+
| CUST_ID | CUST_BIRTH          | VIST_CNT |
+---------+---------------------+----------+
| 78693   | 1977-07-07 00:00:00 |      103 |
| 23472   | 1978-02-27 00:00:00 |      117 |
| 56456   | 1982-01-24 00:00:00 |      123 |
| 27896   | 1982-05-11 00:00:00 |       37 |
| 35478   | 1983-09-10 00:00:00 |       86 |
| 65412   | 1984-05-10 00:00:00 |       23 |
+---------+---------------------+----------+
6 rows in set (0.000 sec)

MariaDB [studydb]> select CUST_ID,VIST_CNT,SALSE_AMT from test1 order by VIST_CNT desc;
+---------+----------+-----------+
| CUST_ID | VIST_CNT | SALSE_AMT |
+---------+----------+-----------+
| 56456   |      123 |   3700000 |
| 23472   |      117 |   2237065 |
| 78693   |      103 |   1789023 |
| 35478   |       86 |    830000 |
| 27896   |       37 |    123721 |
| 65412   |       23 |    467200 |
+---------+----------+-----------+
6 rows in set (0.000 sec)