// 활용 - 지정한 폴더에서 .class 파일만 찾아 출력하라.
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0740 {

  public static void main(String[] args) throws Exception {

    File dir = new File("bin/main");
    System.out.println(dir.getCanonicalPath());

    printClasses(dir);
  }

  static void printClasses(File dir) {
    // 먼저 현재 폴더 출력하기
    File[] files = dir.listFiles();// 파일에서 리스트 만들기
    for (File f : files) { // 다 반복하기
      if (f.isFile() && f.getName().endsWith(".class")) {
        // 그 중에 파일과 그 파일 마지막 이름 .class로 나오면 true로 반환
        System.out.println(f.getName());
      }
    }


  }
}


