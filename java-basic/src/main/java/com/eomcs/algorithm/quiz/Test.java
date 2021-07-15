package com.eomcs.algorithm.quiz;

public class Test {

  static int maxDiff(int[] values) {
    int result = 1;
    for(int i = 0; i < values.length - 1; i++) {
      int diff = Math.abs(values[i] - values[i + 1]);
      if(diff < result) {
        result = diff;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    //int[] arr = new int[] {2, 4, 1, 0};
    //int result = maxDiff(arr);
    //System.out.println(result);
    System.out.println(maxDiff(new int[]{2, 4, 1, 0}));

  }
}


