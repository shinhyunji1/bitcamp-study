package com.eomcs.menu;

public abstract class Menu {

  public static final int ACCESS_LOGOUT = 0x01;  // 0001
  public static final int ACCESS_GENERAL = 0x02; // 0010
  public static final int ACCESS_ADMIN = 0x04;   // 0100

  String title;

  int accessScope;

  public Menu(String title) { // 엑세스 범위를 안주면 아예 권한이 없는 것.
    this(title, ACCESS_LOGOUT | ACCESS_GENERAL | ACCESS_ADMIN); 
  } // 모든 사람 접근 가능!

  public Menu(String title, int accessScope) {
    this.title = title;
    this.accessScope = accessScope;
  }

  public abstract void execute();
}
