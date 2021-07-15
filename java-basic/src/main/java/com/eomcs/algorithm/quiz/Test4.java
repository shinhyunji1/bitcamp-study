package com.eomcs.algorithm.quiz;

public class Test4 {

  //숫자 배열이 있다.
  //나누어 0이 떨어지는 수가 몇 쌍이 있는지 구하라!

  public static int divisorsPairs(int[] sequence) {
    int count = 0;
    for(int i = 0; i < sequence.length; i++) {
      for(int j = i + 1; j < sequence.length; j++) {
        System.out.printf("%d <--> %d\n", sequence[i], sequence[j]);
        if(sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
          count++;
        }
      }
    }
    return count;
  }

  /*
    int result = 0;

    for (int i = 0; i < sequence.length; i++) {
      for (int j = i + 1; j < sequence.length; j++) {
        //비교할 대상 확인
        System.out.printf("%d <--> %d\n",sequence[i], sequence[j]);
        if (sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
          result++;
        }
      }
    }

    return result;
  }
   */

  public static void main(String[] args) {
    int[] values = {2, 4, 7, 2, 14, 3, 9};
    //int[] values = {8, 4, 2, 3, 6, 10, 5};
    System.out.println(divisorsPairs(values));

  }
}


