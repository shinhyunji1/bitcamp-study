package com.eomcs.pms.handler;

import com.eomcs.menu.Menu;

public class AuthLogoutHandler implements Command {
  @Override
  public void execute(CommandRequest requset) {
    System.out.println("[로그아웃]");

    AuthLoginHandler.loginUser = null;
    AuthLoginHandler.userAccessLevel = Menu.ACCESS_LOGOUT;
    System.out.println("로그아웃 하였습니다.");
  }
}







