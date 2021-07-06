package com.eomcs.lang.ex03;

public class Exam0410 {

  public static void main(String[] args) {
    //작은 따옴표로 문자 표현
    System.out.println('A');
    System.out.println('가');

    //직접 문자를 적는 대신 부여된 코드 값을 지정한다.
    // \ u 뒤에 문자에 부여된 코드 값을 16진수로 적는다.
    System.out.println('\u0041');
    System.out.println('\uac00');
    System.out.println('\uAC00');

    // \뒤에 바로 8진수로 적을 수 있다.
    //단, 범위는 0~377
    System.out.println('\101');
    System.out.println('\122');
    System.out.println('\377');
    //System.out.println('\477');
    //477은 범위에 벗어났기에 오류가 뜬다.

    //특수문자, 키보드로 문자를 직접 입력할 수 없을 때 쓴다.
    System.out.println('\u4eba');
    System.out.println('\u00a9');
    System.out.println('\u03c0');
    System.out.println('\u03a3');

    /*
     문자를 메모리에 저장하려면 2진수로 바꿀 수 있어야 한다.
     2진수로 바꾸는 규칙을 "문자 집합"이라고 한다.
     문자 집합은 여러 규칙이 있다.

     아스키,IOS-8859-1, EUC-KR, Unicode, UTF-8가 있다.

     1)아스키
       한글은 정의되어 있지 않다.
       영어 대소문자, 숫자, 특수문자 등

     2)IOS-8859-1
       8비트로 아스키 문자 + 유럽 문자이다.

     3)EUC-KR
       한글 2350자 +a 
       영어 ISO-8869-1 사용

     4)Unicode
       영어, 한글 모두 2바이트로 표현
       일반적으로 통용되는 대부분의 국가의 문자를 담고 있다.
       하지만, 영어를 2바이트로 표현하기 때문에 비효율적
       (EUC-KR과는 호환X)

     5)UTF-8
       1~4바이트로 표현한다.
       (1byte=4bit, 2byte=8bit, 4byte=16bit)
       한글은 3바이트, 영어/숫자/특수문자는 1바이트
     */

    /*
     폰트
     1)Raster 폰트
       크기를 늘리면 계단현상 발생
       폰트를 도트 정보로 저장
       출력 속도 빠르다

     2)Vector 폰트
       크기를 늘려도 깔끔하게 출력
       폰트를 명령어로 저장
       출력 속도 느리다
     */
  }

}
