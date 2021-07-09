// 관계 연산자 : 부동소수점 비교 
package com.eomcs.lang.ex05;

public class Exam0220 {
  public static void main(String[] args) {
    double d1 = 987.6543;
    double d2 = 1.111111;
    System.out.println((d1 + d2) == 988.765411);
    // 결과는 false이다.
    // 이유?
    // - 부동소수점 값을 연산할 때 IEEE 754 명세에 따라 
    //   작업을 수행한다. 그 과정에 값의 왜곡이 발생할 수 있다.
    // - CPU나 OS, JVM의 문제가 아니다.
    // - IEEE 754 명세에 따라 부동소수점을 처리하는 모든 
    //   컴퓨터에서 발생하는 문제이다.
    System.out.println(d1);
    System.out.println(d2);
    System.out.println(d1 + d2); 
    // 987.6543 + 1.111111 = 988.7654110000001
    // => 결과 뒤에 극소수의 값이 붙는다.
    // => 그래서 부동 소수점의 비교를 대충 다루지 말라!
    // 0 10000001000 1110110111010011110000000001101000110110111000101111 (987.6543)
    // 0 01111111111 0001110001110001110001010011111100111001110100011011 (1.111111)
    //
    // 1.1110110111010011110000000001101000110110111000101111
    // 0.0000000010001110001110001110001010011111100111001110
    //---------------------------------------------------------
    // 1.1110111001100001111110001111110011010110011111111101
    //
    // 0 10000001000 1110111001100001111110001111110011010110011111111101
    // 0 10000001000 1110111001100001111110001111110011010110011111111101

    double x = 234.765411;
    double y = 754.0;
    System.out.println((x + y) == 988.765411);

    System.out.println(x);
    System.out.println(y);
    System.out.println(x + y);
    // d1 + d2와 달리 x + y의 계산 결과는 뒤에 극소수의 값이 붙지 않는다.
    // 234.765411 + 754.0 = 988.765411
    // 
    // 0 10000000110 1101010110000111111000111111001101011001111111110101 (234.765411)
    // 0 10000001000 0111100100000000000000000000000000000000000000000000 (754.0)
    //
    // 0.0111010101100001111110001111110011010110011111111101
    // 1.0111100100000000000000000000000000000000000000000000
    // ------------------------------------------------------
    // 1.1110111001100001111110001111110011010110011111111101
    //
    // 0 10000001000 1110111001100001111110001111110011010110011111111101
    //

    // IEEE 754의 변환 공식에 따라 발생되는 이런 문제를 
    // 실무 프로그래밍 할 때 해결하는 방법?
    //
    System.out.println((d1 + d2) == (x + y)); // false

    // 소수점 뒤에 붙은 극소수의 값을 무시하면 된다.
    // => JVM이 자동으로 처리하지 않는다.
    // => 다음과 같이 개발자가 직접 처리해야 한다.
    double EPSILON = 0.00001;
    System.out.println(Math.abs((d1 + d2) - (x + y)) < EPSILON);
    //둘 중에 빼고 음수가 나올 수 있으니 앱솔루트를 사용하여 자동 양수가 나오도록 한다.
  }
}
