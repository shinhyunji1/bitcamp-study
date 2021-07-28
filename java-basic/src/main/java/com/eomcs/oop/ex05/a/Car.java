package com.eomcs.oop.ex05.a;

public class Car {
  //인스턴스 변수 3
  public String model;
  public String maker;
  public int capacity;

  public Car() {}

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


