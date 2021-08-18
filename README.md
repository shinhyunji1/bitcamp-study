# bitcamp-study

##1일차
-아무거나

-다시 추가

-아무거나2

-아무거나3

##2일차
-mac 사용설정
    -git 설정
        -복제해서clone
        -추가/삭제/변경을 하면 리스트를 만들고add, 로컬저장소에 백업commit, 서버저장소에 업로드push
        -가져오기pull
    -vscode 설치
        -사이트에 mac os버전 다운로드
    -git-csm.com에서 설치 대신 homedrew 설치
        -https://whitepaek.tistory.com/3
        -이거 보고 따라함
    -node.js 설치
        -터미널에 $ brew install node 치면 자동으로 설치된다.
    -jdk 설치
        -graalvm.org 사이트에서 다운로드

-윈도우 사용설정
    -git 설정
        -복제해서clone
        -추가/삭제/변경을 하면 리스트를 만들고add, 로컬저장소에 백업commit, 서버저장소에 업로드push
        -가져오기pull
    -vscode 설치
        -사이트에서 window 버전 다운로드
    -c/c++ 컴파일러 설치
        -mingw-w64 다운로드(gcc 설치를 위해)
        -환경변수 PATH에 등록해서 편하다.
    -node.js 설치
    -JDK 설치
    


##6일차 
-리터럴 : 값을 표현한 것(정수, 부동소수점, 논리, 문자, 문자열)
   
-콘솔 출력
문자열 출력 : System.out.print(출력할 값, 표현식)
값 출력 후 줄 바꿈 : System.out.println()
출력형식에 맞춰 값 출력 : System.out.printf("출력혈식", 값, 값, ...)
*print, println, printf가 메소드이다.

정수리터럴              부동소수점 리터럴       논리        문자        문자열

100 10진수              3.14                    true        'A'         "가"
0144 8진수              31.4e-1 / 31.4E-1       false
0x64 16진수             314e-2 / 314E-2
0X64 16진수             0.314e1
0b01100100 2진수        0.0314e2
0B01100100 2진수

값 - 리터럴
오늘 복습은 이클리스로 시작하다가
리터럴 공부하고
책도 주가하ㅐ서ㅓ 읽기

오늘했던거 하고 이번 달 강의 듣고 있었는거 강의 듣기

높은 해상도 
    



##7월 9일 금요일

*배열
배열이란 같은 종류와 크기를 가진 메모리를 여러개 선언하는 벙법(date type)

배열을 쓰는 방법
메모리준비명령 data type [개수]
= new int[3];

변수를 가리지는 번호:index
     0       1       2
   [____]  [____]  [____]
    int     int     int
정수값을 담을 수 있는 4바이트 크기의 메모리

*배열 변수 접근
int[] arr;
arr = new int[5];


*배열레퍼런스와 인스턴스
int[] arr = new int[3];

*자바의 변수 종류
byte b;
short s;
int i;
long l;
float f;
double d;
boolean bool;
char c;
그외 주소를 담는 변수인 레퍼런스이다.(배열 레퍼런스 포함)
    


