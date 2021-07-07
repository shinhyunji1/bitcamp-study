package com.eomcs.pms;

public class App {
  public static void main(String[] args) {
    java.util.Scanner keyboardScanner = new java.util.Scanner(System.in);
    //키보드 System.in이라는 것
    //설계도를 만들어보면 new java.util.Scanner(System.in);
    //가로 안에 무엇을 주냐에 따라 무엇을 스캔할지 정해진다.
    //리모컨을 만들자 : java.util.Scanner keyboardScanner
    //너무 기니깐 import를 주자 (import java.util.Scanner)
    //Scanner keyboardScanner = new Scanner(System.in);

    System.out.println("[회원]");

    System.out.print("번호? ");
    int no = keyboardScanner.nextInt();

    keyboardScanner.nextLine();
    System.out.print("이름? ");
    String name = keyboardScanner.nextLine();

    System.out.print("이메일? ");
    String email = keyboardScanner.nextLine();

    System.out.print("암호? ");
    String password = keyboardScanner.nextLine();

    System.out.print("사진? ");
    String photo = keyboardScanner.nextLine();

    System.out.print("전화? ");
    String tel = keyboardScanner.nextLine();


    java.sql.Date registeresDate = new java.sql.Date(System.currentTimeMillis());

    System.out.println("-----------------------------");

    keyboardScanner.close();

    System.out.println("[회원]");
    System.out.printf("번호 : %s\n ", no);
    System.out.printf("이름 : %s\n", name);
    System.out.printf("이메일 : %s\n", email);
    System.out.printf("암호 : %s\n", password);
    System.out.printf("사진 : %s\n", photo);
    System.out.printf("전화 : %s\n", tel);
    System.out.printf("가입일 : %s\n", registeresDate);
  }
}
