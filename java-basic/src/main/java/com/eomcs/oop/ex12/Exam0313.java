// 아규먼트에 람다(lambda) 활용
package com.eomcs.oop.ex12;

public class Exam0313 {

  static interface Player {//인터페이스의 메서드 하나일 경우 람다식 가능!
    void play();
  }

  static void testPlayer(Player player) {
    player.play();
  }

  public static void main(String[] args) {
    // 아규먼트 자리에 lambda 문법을 사용하면 더 편하다!
    testPlayer(() -> System.out.println("실행~~~~"));
  }

}


