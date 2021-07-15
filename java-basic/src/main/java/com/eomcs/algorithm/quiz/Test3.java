package com.eomcs.algorithm.quiz;

public class Test3 {
  static void changeValuePosition(int[] values) {
    int half = values.length >> 1;
    int addIndex = values.length & 1;
    int tmp = 0;
    for (int i = 0; i < half; i++) {
      tmp = values[i];
      values[i] = values[i + half + addIndex];
      values[i + half + addIndex] = tmp;
    }
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 5, 6, 9, 4, 3, 7, 8};
    changeValuePosition(values);

    for (int v : values) {
      System.out.print(v + ",");
    }
  }
}


