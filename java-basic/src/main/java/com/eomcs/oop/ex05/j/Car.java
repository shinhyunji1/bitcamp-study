package com.eomcs.oop.ex05.j;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public Car() {}//기본 생성자

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


