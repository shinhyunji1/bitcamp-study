package com.eomcs.oop.ex00;

import com.eomcs.oop.ex00.util.Calculator;

public class Eaxm0500 {

  public static void main(String[] args) {
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    //클래스 설계도에 따라서 heap영역에 변수를 만들어야 한다.
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);//2)
    c2.plus(3);//2)

    c1.plus(3);
    c2.multiple(2);

    c1.minus(1);//3)
    c2.plus(7);//3)

    c1.multiple(7);//4)
    c2.divide(4);//4)

    c1.divide(3);//5)
    c2.minus(5);//5)

    System.out.printf("result = %d\n", c1.result);//6)
    System.out.printf("result = %d\n", c2.result);
  }

}

