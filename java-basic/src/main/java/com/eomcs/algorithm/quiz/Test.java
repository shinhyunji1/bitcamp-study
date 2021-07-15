package com.eomcs.algorithm.quiz;

public class Test {

  static int countEvenNumber(int value) {
    int count = 0;
    int n = value;
    while(n > 0) {
      if(n % 2 == 0) {
        count++;
      }
      n /= 10;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(countEvenNumber(1238694636));

  }
}


