package com.eomcs.basic.ex10;

public class Exam0120 {
  public static void main(String[] args) {
    long millis = System.currentTimeMillis();
    System.out.println(millis);

    //리모컨을 실행
    java.util.Date d = new java.util.Date(millis);
    System.out.println(d.toString());
    //리모컨을 가지고 d.toString을 실행한다.

    java.sql.Date d1 = new java.sql.Date(millis);
    System.out.println(d1.toString());
  }
}
