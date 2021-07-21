package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.util.Prompt;

public class App {

  public static void main(String[] args) {

    //각 게시판의 게시글을 담을 메소지를 준비한다.
    // new BoardHandler()
    //  - boardHandler가 작업할 떄 사용할 변수르 준비한다.
    //  - BoardHandler는 게시글을 다루는 작업을 한다.

    BoardHandler boardHandler = new BoardHandler();//보드핸들러 작업할 떄 변수를 준비해라 add/list 메서드를!
    BoardHandler boardHandler2 = new BoardHandler();
    BoardHandler boardHandler3 = new BoardHandler();
    BoardHandler boardHandler4 = new BoardHandler();
    BoardHandler boardHandler5 = new BoardHandler();
    BoardHandler boardHandler6 = new BoardHandler();

    MemberHandler memberHandler = new MemberHandler();

    ProjectHandler projectHandler = new ProjectHandler();//사용할 메모리는 ex)300번지라는 주소를 준다.

    TaskHandler taskHandler = new TaskHandler();

    while (true) {
      String input = Prompt.inputString("명령> ");

      if (input.equals("exit") || input.equals("quit")) {
        System.out.println("안녕!");
        break;
      } else if (input.equals("/member/add")) {
        memberHandler.add();//메서든 하나

      } else if (input.equals("/member/list")) {
        memberHandler.list();//주소를 주고 

      }  else if (input.equals("/project/add")) {
        projectHandler.add(memberHandler);//호출하고 싶으면 memberHandler를 호출한다.

      }  else if (input.equals("/project/list")) {
        projectHandler.list();

      }  else if (input.equals("/task/add")) {
        taskHandler.add(memberHandler);//

      }  else if (input.equals("/task/list")) {
        taskHandler.list();

      }  else if (input.equals("/board/add")) {
        boardHandler.add();

      }  else if (input.equals("/board/list")) {
        boardHandler.list();

      }  else if (input.equals("/board2/add")) {
        boardHandler2.add();

      }  else if (input.equals("/board2/list")) {
        boardHandler2.list();

      }  else if (input.equals("/board3/add")) {
        boardHandler3.add();

      }  else if (input.equals("/board3/list")) {
        boardHandler3.list(); //거기에 있는 배열과 사이즈를 출력해라

      }  else if (input.equals("/board4/add")) {
        boardHandler4.add();

      }  else if (input.equals("/board4/list")) {
        boardHandler4.list();

      }  else if (input.equals("/board5/add")) {
        boardHandler5.add();

      }  else if (input.equals("/board5/list")) {
        boardHandler5.list();

      }  else if (input.equals("/board6/add")) {
        boardHandler6.add();

      }  else if (input.equals("/board6/list")) {
        boardHandler6.list();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println();
    }

    // Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
    Prompt.close();
  }
}











