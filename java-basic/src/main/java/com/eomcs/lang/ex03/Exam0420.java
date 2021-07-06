package com.eomcs.lang.ex03;

public class Exam0420 {

  public static void main(String[] args) {

    //숫자만 전달하면 숫자만 출력한다.
    System.out.println(65);

    //숫자 앞에 (char)를 붙이면 문자코드가 된다.
    System.out.println((char)65);

    //16진수 앞에 (char)를 붙이면 문자코드가 된다.
    System.out.println((char)0x41);

    //한글 '가'를 문자 코드를 이용하여 출력하기
    System.out.println((char)0xAC00);

    //'가' 다음 문자를 출력하기 위해서 +1를 추가
    System.out.println((char)(0xAC00 + 1));


    for(int i =0; i < 26; i++) {
      System.out.print((char)(i + 65) + ",");
    }



  }

}
