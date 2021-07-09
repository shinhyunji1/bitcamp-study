package com.eomcs.pms;

import java.sql.Date;

public class Pms02b2 {

  public static void main(String[] args) {
    java.util.Scanner Scannerkeyboard = new java.util.Scanner(System.in);


    System.out.println("[프로젝트]");
    System.out.print("번호? ");
    int no = Scannerkeyboard.nextInt();
    Scannerkeyboard.nextLine();

    System.out.print("프로젝트명? ");
    String projectname = Scannerkeyboard.nextLine();

    System.out.print("내용? ");
    String blank = Scannerkeyboard.nextLine();

    System.out.print("시작일? ");
    java.sql.Date startDate = java.sql.Date.valueOf(Scannerkeyboard.nextLine());
    //

    System.out.print("종료일? ");
    Date endDate = Date.valueOf(Scannerkeyboard.nextLine());



    System.out.print("만든이? ");
    String made = Scannerkeyboard.nextLine();

    System.out.print("팀원? ");
    String members = Scannerkeyboard.nextLine();


    Scannerkeyboard.close();


    System.out.println("-----------------------------");


    System.out.printf("번호: %d\n", no);
    System.out.printf("프로젝트명: %s\n", projectname);
    System.out.printf("내용: %s\n", blank);
    System.out.printf("시작일: %s\n", startDate);
    System.out.printf("종료일: %s\n", endDate);
    System.out.printf("만든이: %s\n", made);
    System.out.printf("팀원: %s\n", members);

  }

}
