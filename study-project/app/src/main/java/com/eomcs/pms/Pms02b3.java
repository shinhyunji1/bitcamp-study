package com.eomcs.pms;

import java.sql.Date;

public class Pms02b3 {

  public static void main(String[] args) {
    java.util.Scanner Scannerkeyboard = new java.util.Scanner(System.in);

    System.out.println("[작업]");

    System.out.print("프로젝트? ");
    String project = Scannerkeyboard.nextLine();

    System.out.print("번호? ");
    int no = Scannerkeyboard.nextInt();
    Scannerkeyboard.nextLine();

    System.out.print("내용? ");
    String content = Scannerkeyboard.nextLine();

    System.out.print("완료일? ");
    Date endDate = Date.valueOf(Scannerkeyboard.nextLine());



    System.out.print("상태? \n0:신규 \n1:진행중 \n2:완료 \n>");
    int ing = Scannerkeyboard.nextInt();
    Scannerkeyboard.nextLine();

    System.out.print("담당자? ");
    String member = Scannerkeyboard.nextLine();


    System.out.println("------------------------");


    System.out.printf("프로젝트: %s\n", project);
    System.out.printf("번호: %s\n", no);
    System.out.printf("내용: %s\n", content);
    System.out.printf("완료일: %s\n", endDate);
    switch(ing) {
      case 0:
        System.out.println("상태:신규");
        break;
      case 1:
        System.out.println("상태:진행중");
        break;
      case 2:
        System.out.println("상태:완료");
        break;
    }
    System.out.printf("담당자: %s\n", member);
  }

}
