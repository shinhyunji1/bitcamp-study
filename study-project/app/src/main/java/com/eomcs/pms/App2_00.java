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

public class App2 {

  public static void main(String[] args) {
    System.out.println("[프로젝트]");

    final int MAX_LENGTH = 3;

    int[] no = new int[MAX_LENGTH];
    String[] title = new String[MAX_LENGTH];
    String[] content = new String[MAX_LENGTH];
    Date[] startDate = new Date[MAX_LENGTH];
    Date[] endDate = new Date[MAX_LENGTH];
    String[] owner = new String[MAX_LENGTH];
    String[] members = new String[MAX_LENGTH];


    Scanner keyboardScan = new Scanner(System.in);


    int size = 0;
    for (int i = 0; i < MAX_LENGTH; i = i + 1) {

      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();
      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();
      System.out.print("시작일? ");
      startDate[i] = new Date();
      keyboardScan.nextLine(); // 번호 뒤에 남아 있는 줄바꿈 코드를 제거한다.
      System.out.print("종료일? ");
      endDate[i] = new Date();
      keyboardScan.nextLine(); // 번호 뒤에 남아 있는 줄바꿈 코드를 제거한다.
      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();
      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();
      System.out.println();
      size = size + 1;


      System.out.print("계속 입력하시겠습니까? (y/N)");
      String input = keyboardScan.nextLine();
      if(input.equalsIgnoreCase("N") || input.equals("")) {
        break;
      }

    }




    keyboardScan.close();

    System.out.println("--------------------------------");



    for (int i = 0; i < size; i = i + 1) {

      System.out.printf("%d, %s, %tY-%3$tm-%3$td, %tY-%4$tm-%4$td, %s",
          no[i],
          title[i],
          startDate[i],
          endDate[i],
          owner[i]);

      System.out.println();



    }


  }
}
