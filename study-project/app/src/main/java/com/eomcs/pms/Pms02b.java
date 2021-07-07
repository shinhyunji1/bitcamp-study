package com.eomcs.pms;

public class Pms02b {

  public static void main(String[] args) {
    java.util.Scanner keyboard = new java.util.Scanner(System.in);


    //키보드 System.in이라는 것
    //설계도를 만들어보면 new java.util.Scanner(System.in);
    //가로 안에 무엇을 주냐에 따라 무엇을 스캔할지 정해진다.
    //리모컨을 만들자 : java.util.Scanner keyboardScanner
    System.out.println("[회원]");

    System.out.print("번호? ");
    int num = keyboard.nextInt();

    keyboard.nextLine();
    System.out.print("이름? ");
    String name = keyboard.nextLine();

    System.out.print("이메일? ");
    String email = keyboard.nextLine();

    System.out.print("암호? ");
    int pass = keyboard.nextInt();

    keyboard.nextLine();
    System.out.print("사진? ");
    String pic = keyboard.nextLine();

    System.out.print("전화? ");
    String phone = keyboard.nextLine();

    keyboard.close();

    System.out.println("----------------------------");

    System.out.println("[회원]");
    System.out.printf("번호: %d\n", num);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %d\n", pass);
    System.out.printf("사진: %s\n", pic);
    System.out.printf("전화: %s\n", phone);



  }

}
