// Stack의 Iterator와 Deque의 Iterator 차이점
package com.eomcs.basic.ex05;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Exam0220 {

  public static void main(String[] args) {

    ArrayDeque<String> stack = new ArrayDeque<>();

    // 다음과 같이 스택으로서 사용할 수 있다.
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    Iterator<String> iterator = stack.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    //여기서 잠깐!
    // Iterator 설계 기법의 목적
    // - 데이터 조회 방식(LIFO, FIFO)에 상관없이
    // 일관된 방법으로 데이터를 조회할 수 있

  }

}

