package com.eomcs.menu;

public abstract class Menu {

  public static final int ENABLE_ALL = 0; // 모든 경우에 0이다.
  public static final int ENABLE_LOGOUT = 2;
  public static final int ENABLE_LOGIN = 1;

  String title;

  int enableState;

  public Menu(String title) {
    this.title = title;
  }

  public Menu(String title, int enableState) {
    this(title);// 메뉴 이름 설정은 기존 생성자를 통해 처리한다.
    //  this.title = title;
    this.enableState = enableState;
  }

  public abstract void execute();
}
