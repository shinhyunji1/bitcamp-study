package com.eomcs.basic.ex10;

public class Exam0110 {
  public static void main(String[] args) {


    //리모컨을 실행
    java.util.Date d = new java.util.Date();//Date 객체를 만드는 순간의 시각을 저장해 둔다.
    System.out.println(d.toString());
    //리모컨을 가지고 d.toString을 실행한다.
    System.out.printf("%tY-%tm-%td\n", d, d, d);
    System.out.printf("%tY-%1$tm-%1$td\n", d);

  }
}
