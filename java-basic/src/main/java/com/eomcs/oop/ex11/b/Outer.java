package com.eomcs.oop.ex11.b;

public class Outer {
  class Inner {
    int iv = 100;
  }
}

class Ex {
  public static void main(String[] args) {
    Outer.Inner obj = new Outer.Inner();
  }
}
