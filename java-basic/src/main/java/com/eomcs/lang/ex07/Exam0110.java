package com.eomcs.lang.ex07;

import java.util.Scanner;

//# 메서드 : 사용 전
//
public class Exam0110 {
  public static void main(String[] args) {

    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    int starLen = 1;//출력될 별 개수는 1부터이니깐 1로 초기
    while (starLen <= len) {
      // 별 앞에 공백 출력
      int spaceCnt = 1;//공백을 출력해야하니깐 1개부터 출력해야함
      int spaceLen = (len - starLen) / 2;//전체 길이에서 양쪽에 공백을 줘야함 2로 나누고 앞에 출력하는 
      while (spaceCnt <= spaceLen) {//1부터 스페이스 길이만큼 반복문 실행
        System.out.print(" ");
        spaceCnt++;//실행할때마다 1씩 증가
      }

      // 별 출력
      int starCnt = 1;
      while (starCnt <= starLen) {
        System.out.print("*");
        starCnt++;
      }

      // 출력 줄 바꾸기
      System.out.println();
      starLen += 2;//별 개수는 2 증
    }
  }
}