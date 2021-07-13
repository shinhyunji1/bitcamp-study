package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

//1)변경 준비
//2)사용자에게 명령 프롬프트 출력
//3)사용자의 명령을 입력 받아 출력
//4)명령를 입력받아 출력하는 것을 무한 반복
//5)exit나 quit 명력을 입력하면 반복 실행 중
//6)/member/add와 /member/list명령을 구분해 보자!
//7)/member/add 명령 처리
//8)/member/list 명령 처리
public class App2 {

  public static void main(String[] args) {
    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] title = new String[LENGTH];
    String[] content = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    String[] members = new String[LENGTH];

    int size = 0;//배열 변수를 설정하여 횟수를 추가 계속 추가한다.

    while(true) {
      System.out.print("명령> ");
      String input = keyboardScan.nextLine();
      if(input.equals("exit") || input.equals("quit")) {
        break;
      } else if(input.equals("/member/add")) {
        System.out.println("[프로젝트등록]");

        System.out.print("번호? ");
        no[size] = Integer.valueOf(keyboardScan.nextLine());

        System.out.print("프로젝트명? ");
        title[size] = keyboardScan.nextLine();

        System.out.print("내용? ");
        content[size] = keyboardScan.nextLine();

        System.out.print("시작일? ");
        startDate[size] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("종료일? ");
        endDate[size] = Date.valueOf(keyboardScan.nextLine());

        System.out.print("만든이? ");
        owner[size] = keyboardScan.nextLine();

        System.out.print("팀원? ");
        members[size] = keyboardScan.nextLine();

        size++;

      } else if(input.equals("/member/list")) {
        System.out.println("[프로젝트목록]");

        for (int i = 0; i < size; i++) {
          // 번호, 프로젝트명, 시작일, 종료일, 만든이
          System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
              no[i], title[i], startDate[i], endDate[i], owner[i]);
        }

      } else {
        System.out.println("실행할 수 없는 명령입니다.");

      }
      System.out.println();
    }
    keyboardScan.close();

    /*
    System.out.println("[프로젝트]");


    // 최대 100개의 프로젝트 정보를 저장할 메모리 준비
    // => 배열의 크기를 미리 변수에 저장하여 사용한다.
    // => 나중에 배열의 크기를 바꾸기 쉽다.
    final int LENGTH = 100;

    int[] no = new int[LENGTH];
    String[] title = new String[LENGTH];
    String[] content = new String[LENGTH];
    Date[] startDate = new Date[LENGTH];
    Date[] endDate = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    String[] members = new String[LENGTH];

    int size = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.valueOf(keyboardScan.nextLine());

      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();

      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();

      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();

      size++;
      System.out.println(); // 빈 줄 출력

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = keyboardScan.nextLine();
      if (!str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println(); // 빈 줄 출력
    }

    keyboardScan.close();

    System.out.println("--------------------------------");


    for (int i = 0; i < size; i++) {
      // 번호, 프로젝트명, 시작일, 종료일, 만든이
      System.out.printf("%d, %s, %s, %s, %s\n", // 출력 형식 지정
          no[i], title[i], startDate[i], endDate[i], owner[i]);
    }
     */
  }
}
