package com.eomcs.pms;

import java.util.Date;
import java.util.Scanner;

//1)배열 사용 전 
//2)배열 사용 후
//3)반복문 적용 : while
//4)반복문 적용 : for
//5)여러 문장에서 반복해서 사용하는 값을 변수에 담아서 사용한다.
//6)조회용으로만 사용할 변수라면 상수로 선언한다.
//7)특정 조건에 따라 반복을 멈춘다.
//8)날짜의 출력형식을 "yyyy-MM-dd"로 변경한다.

public class App3_1 {

  public static void main(String[] args) {

    Scanner keyboardScan = new Scanner(System.in);
    System.out.println("[작업]");

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();
    System.out.println();

    final int MAX_LENGTH = 3;
    int[] no = new int[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] deadline = new Date[MAX_LENGTH];
    int[] status = new int[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];



    int size = 0;
    for (int i= 0; i < MAX_LENGTH; i = i + 1) {


      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      System.out.print("마감일? ");
      deadline[i] = new Date();
      keyboardScan.nextLine();
      System.out.println("상태?");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.print("> ");
      status[i] = Integer.valueOf(keyboardScan.nextLine());
      System.out.print("담당자? ");
      owner[i] = keyboardScan.nextLine();
      System.out.println();
      size = size + 1;

      System.out.print("계속 입력하시겠습니까? (y/N)");
      String input = keyboardScan.nextLine();
      if (input.equalsIgnoreCase("N") || input.equals("")) {
        break;
      }
      System.out.println();



    }



    keyboardScan.close();

    System.out.println("--------------------------------");


    System.out.printf("%s\n", project);
    //MAX_LENGTH = 2;
    for (int i = 0; i < size; i = i + 1) {

      String line;
      switch (status[i]) {
        case 1:
          line = "진행중";
          break;
        case 2:
          line = "완료";
          break;
        default:
          line = "신규";
      }
      System.out.printf("%d, %s, %tY-%3$tm-%3$td, %s, %s\n",
          no[i],content[i], deadline[i], line, owner[i]);

      System.out.println();


    }

  }
}
