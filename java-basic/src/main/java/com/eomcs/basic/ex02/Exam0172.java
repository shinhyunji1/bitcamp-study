// String - 기타 메서드 : join()
package com.eomcs.basic.ex02;

import java.util.Arrays;

public class Exam0172 {
  public static void main(String[] args) {

    String[] arr = {"101", "제목", "내용", "4", "2021-2-2"};

    String[] arr2 = Arrays.copyOfRange(arr, 2, 4);
    for (String s : arr2) {
      System.out.println(s);
    }

  }
}


