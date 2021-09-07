package com.eomcs.pms;

import static com.eomcs.menu.Menu.ACCESS_ADMIN;
import static com.eomcs.menu.Menu.ACCESS_GENERAL;
import static com.eomcs.menu.Menu.ACCESS_LOGOUT;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import com.eomcs.menu.Menu;
import com.eomcs.menu.MenuGroup;
import com.eomcs.pms.domain.Board;
import com.eomcs.pms.domain.Member;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.handler.AuthLoginHandler;
import com.eomcs.pms.handler.AuthLogoutHandler;
import com.eomcs.pms.handler.AuthUserInfoHandler;
import com.eomcs.pms.handler.BoardAddHandler;
import com.eomcs.pms.handler.BoardDeleteHandler;
import com.eomcs.pms.handler.BoardDetailHandler;
import com.eomcs.pms.handler.BoardListHandler;
import com.eomcs.pms.handler.BoardSearchHandler;
import com.eomcs.pms.handler.BoardUpdateHandler;
import com.eomcs.pms.handler.Command;
import com.eomcs.pms.handler.MemberAddHandler;
import com.eomcs.pms.handler.MemberDeleteHandler;
import com.eomcs.pms.handler.MemberDetailHandler;
import com.eomcs.pms.handler.MemberListHandler;
import com.eomcs.pms.handler.MemberPrompt;
import com.eomcs.pms.handler.MemberUpdateHandler;
import com.eomcs.pms.handler.ProjectAddHandler;
import com.eomcs.pms.handler.ProjectDeleteHandler;
import com.eomcs.pms.handler.ProjectDetailHandler;
import com.eomcs.pms.handler.ProjectListHandler;
import com.eomcs.pms.handler.ProjectPrompt;
import com.eomcs.pms.handler.ProjectUpdateHandler;
import com.eomcs.pms.handler.TaskAddHandler;
import com.eomcs.pms.handler.TaskDeleteHandler;
import com.eomcs.pms.handler.TaskDetailHandler;
import com.eomcs.pms.handler.TaskListHandler;
import com.eomcs.pms.handler.TaskUpdateHandler;
import com.eomcs.util.Prompt;

public class App {
  List<Board> boardList = new ArrayList<>();
  List<Member> memberList = new LinkedList<>();
  List<Project> projectList = new ArrayList<>();

  HashMap<String,Command> commandMap = new HashMap<>();
  MemberPrompt memberPrompt = new MemberPrompt(memberList);
  ProjectPrompt projectPrompt = new ProjectPrompt(projectList);

  // 이너 클래스 : Menu 추상 클래스를 상속 받아서 PMS 시스템에 맞게 기능을 추가한다.
  class MenuItem extends Menu {

    // inner 클래스는 컴파일할 때 바깥 클래스의 인스턴스를 저장할 필드가 자동 생성된다.
    // 개발자가 따로 선언할 필요가 없다.
    // 예) App this$1;

    // 1) 메뉴의 ID를 저장할 필드를 선언한다.
    // - 이 메뉴 아이디는 커맨드 객첼를 찾을 때 사용할 것이다.
    String menuId;

    public MenuItem(/*App outer*/String title, String menuId) {
      super(title);
      this.menuId = menuId;
    }

    // inner 클래스의 생성자를 컴파일할 때
    // 바깥 클래스의 인스턴스를 받는 파라미터가 자동으로 추가된다.
    // 개발자가 따로 파라미터를 추가할 필요가 없다.
    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
      //this$0 = outer;
    }

    @Override
    public void execute() {
      // inner 클래스는 바깥 클래스의 인스턴스를 내부 필드로 갖고 있기 때문에
      // inner 클래스의 멤버를 마음대로 사용할 수 있다.

      // 메뉴가 실행될 때 메뉴 아이디를 사용하여 Map에서 Command 객체를 찾아 실행한다.
      Command command = commandMap.get(menuId);
      command.execute();
    }
  }


  public static void main(String[] args) {
    App app = new App(); 
    app.service();
  }

  public App() {
    //생성자를 준비한다.
    commandMap.put("/board/add", new BoardAddHandler(boardList));
    commandMap.put("/board/list", new BoardListHandler(boardList));
    commandMap.put("/board/detail", new BoardDetailHandler(boardList));
    commandMap.put("/board/update", new BoardUpdateHandler(boardList));
    commandMap.put("/board/delete", new BoardDeleteHandler(boardList));
    commandMap.put("/board/search", new BoardSearchHandler(boardList));

    commandMap.put("/member/add", new MemberAddHandler(memberList));
    commandMap.put("/member/list", new MemberListHandler(memberList));
    commandMap.put("/member/detail", new MemberDetailHandler(memberList));
    commandMap.put("/member/update", new MemberUpdateHandler(memberList));
    commandMap.put("/member/delete", new MemberDeleteHandler(memberList));

    commandMap.put("/project/add", new ProjectAddHandler(projectList, memberPrompt));
    commandMap.put("/project/list", new ProjectListHandler(projectList));
    commandMap.put("/project/detail", new ProjectDetailHandler(projectList));
    commandMap.put("/project/update", new ProjectUpdateHandler(projectList, memberPrompt));
    commandMap.put("/project/delete", new ProjectDeleteHandler(projectList));

    commandMap.put("/task/add", new TaskAddHandler(projectPrompt));
    commandMap.put("/task/list", new TaskListHandler(projectPrompt));
    commandMap.put("/task/detail", new TaskDetailHandler(projectPrompt));
    commandMap.put("/task/update", new TaskUpdateHandler(projectPrompt));
    commandMap.put("/task/delete", new TaskDeleteHandler(projectPrompt));

    commandMap.put("/auth/login", new AuthLoginHandler(memberList));
    commandMap.put("/auth/logout", new AuthLogoutHandler());
    commandMap.put("/auth/userinfo", new AuthUserInfoHandler());
  }

  void service() {
    createMainMenu().execute();
    Prompt.close();

    // 게시글 데이터를 파일로 내보내기(저장하기, 쓰기)
    try (FileOutputStream out = new FileOutputStream("board.data")) {
      for (Board board : boardList) {
        out.write(board.getNo() >> 24);
        out.write(board.getNo() >> 16);
        out.write(board.getNo() >> 8);
        out.write(board.getNo());

        // 2) 게시글 제목
        byte[] bytes = board.getTitle().getBytes("UTF-8");
        out.write(bytes.length >> 8); // 바이트의 개수를 2바이트로 먼저 출력한다.
        out.write(bytes.length); // 바이트의 개수를 2바이트로 먼저 출력한다.
        out.write(bytes); // 그런 후에 바이트를 출력한다.

        // 3) 게시글 내용 출력
        bytes = board.getContent().getBytes("UTF-8");
        out.write(bytes.length >> 8);// 2바이트로 바이트 배열의 크기를 먼저 출력한다.
        out.write(bytes.length);
        out.write(bytes); // 그런 후에 바이트를 출력한다.

        // 4) 게시글 등록일 출력 (날자를 문자열로 !)
        String dateStr = board.getRegisteredDate().toString(); // "2021-09-07" 10바이트
        bytes = dateStr.getBytes("UTF-8");
        out.write(bytes.length >> 8);
        out.write(bytes.length);
        out.write(bytes);

        // 5) 게시글 조회수 출력
        out.write(board.getViewCount() >> 24);
        out.write(board.getViewCount() >> 16);
        out.write(board.getViewCount() >> 8);
        out.write(board.getViewCount());

        // 6) 게시글 작성자 번호 출력
        out.write(board.getWriter().getNo() >> 24);
        out.write(board.getWriter().getNo() >> 16);
        out.write(board.getWriter().getNo() >> 8);
        out.write(board.getWriter().getNo());

        // 7) 게시글 작성자 이름 출력 (제목과 비슷)
        bytes = board.getWriter().getName().getBytes("UTF-8");
        out.write(bytes.length >> 8); // 바이트의 개수를 2바이트로 먼저 출력한다.
        out.write(bytes.length); // 바이트의 개수를 2바이트로 먼저 출력한다.
        out.write(bytes); // 그런 후에 바이트를 출력한다.
      }
    } catch (Exception e) {
      System.out.println("게시글을 파일에 저장 중 오류 발생!");
    }
  }

  Menu createMainMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));
    mainMenuGroup.add(new MenuItem("내정보", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/userinfo"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_GENERAL | ACCESS_ADMIN, "/auth/logout"));

    mainMenuGroup.add(createBoardMenu());
    mainMenuGroup.add(createMemberMenu());
    mainMenuGroup.add(createProjectMenu());
    mainMenuGroup.add(createTaskMenu());
    mainMenuGroup.add(createAdminMenu());

    return mainMenuGroup;
  }

  private Menu createBoardMenu() {
    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/board/add"));
    boardMenu.add(new MenuItem("목록", "/board/list"));
    boardMenu.add(new MenuItem("상세보기", "/board/detail"));
    boardMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/board/update"));
    boardMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/board/delete"));
    boardMenu.add(new MenuItem("검색", "/board/search"));

    return boardMenu;
  }

  private Menu createMemberMenu() {
    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/member/add"));
    memberMenu.add(new MenuItem("목록", "/member/list"));
    memberMenu.add(new MenuItem("상세보기", "/member/detail"));
    memberMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/member/update"));
    memberMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/member/delete"));
    return memberMenu;
  }

  private Menu createProjectMenu() {
    MenuGroup projectMenu = new MenuGroup("프로젝트");
    projectMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/project/add"));
    projectMenu.add(new MenuItem("목록", "/project/list"));
    projectMenu.add(new MenuItem("상세보기", "/project/detail"));
    projectMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/project/update"));
    projectMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/project/delete"));
    return projectMenu;
  }

  private Menu createTaskMenu() {
    MenuGroup taskMenu = new MenuGroup("작업");
    taskMenu.add(new MenuItem("등록", ACCESS_GENERAL, "/task/add"));
    taskMenu.add(new MenuItem("목록", "/task/list"));
    taskMenu.add(new MenuItem("상세보기", "/task/detail"));
    taskMenu.add(new MenuItem("변경", ACCESS_GENERAL, "/task/update"));
    taskMenu.add(new MenuItem("삭제", ACCESS_GENERAL, "/task/delete"));
    return taskMenu;
  }

  private Menu createAdminMenu() {
    MenuGroup adminMenu = new MenuGroup("관리자", ACCESS_ADMIN);
    adminMenu.add(new MenuItem("회원 등록", "/member/add"));
    adminMenu.add(new MenuItem("프로젝트 등록", "/project/add"));
    adminMenu.add(new MenuItem("작업 등록", "/task/add"));
    adminMenu.add(new MenuItem("게시글 등록", "/board/add"));
    return adminMenu;
  }
  //  Menu createMenu() {
  //    MenuGroup mainMenuGroup = new MenuGroup("메인");
  //    mainMenuGroup.setPrevMenuTitle("종료");
  //
  //    mainMenuGroup.add(new MenuItem("로그인", Menu.ENABLE_LOGOUT, "/auth/login"));
  //
  //    mainMenuGroup.add(new Menu("내정보", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        authUserInfoHandler.execute(); 
  //      }
  //    });
  //
  //    mainMenuGroup.add(new Menu("로그아웃", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        authLogoutHandler.execute(); 
  //      }
  //    });
  //
  //    MenuGroup boardMenu = new MenuGroup("게시판");
  //    mainMenuGroup.add(boardMenu);
  //
  //    boardMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        boardAddHandler.execute(); 
  //      }});
  //    boardMenu.add(new Menu("목록") {
  //      @Override
  //      public void execute() {
  //        boardListHandler.execute(); 
  //      }});
  //    boardMenu.add(new Menu("상세보기") {
  //      @Override
  //      public void execute() {
  //        boardDetailHandler.execute(); 
  //      }});
  //    boardMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        boardUpdateHandler.execute(); 
  //      }});
  //    boardMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        boardDeleteHandler.execute(); 
  //      }});
  //    boardMenu.add(new Menu("검색") {
  //      @Override
  //      public void execute() {
  //        boardSearchHandler.execute(); 
  //      }});
  //
  //    MenuGroup memberMenu = new MenuGroup("회원");
  //    mainMenuGroup.add(memberMenu);
  //
  //    memberMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        memberAddHandler.execute(); 
  //      }});
  //    memberMenu.add(new Menu("목록") {
  //      @Override
  //      public void execute() {
  //        memberListHandler.execute(); 
  //      }});
  //    memberMenu.add(new Menu("상세보기") {
  //      @Override
  //      public void execute() {
  //        memberDetailHandler.execute(); 
  //      }});
  //    memberMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        memberUpdateHandler.execute(); 
  //      }});
  //    memberMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        memberDeleteHandler.execute(); 
  //      }});
  //
  //    MenuGroup projectMenu = new MenuGroup("프로젝트");
  //    mainMenuGroup.add(projectMenu);
  //
  //    projectMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        projectAddHandler.execute(); 
  //      }});
  //    projectMenu.add(new Menu("목록") {
  //      @Override
  //      public void execute() {
  //        projectListHandler.execute(); 
  //      }});
  //    projectMenu.add(new Menu("상세보기") {
  //      @Override
  //      public void execute() {
  //        projectDetailHandler.execute(); 
  //      }});
  //    projectMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        projectUpdateHandler.execute(); 
  //      }});
  //    projectMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        projectDeleteHandler.execute(); 
  //      }});
  //
  //    MenuGroup taskMenu = new MenuGroup("작업");
  //    mainMenuGroup.add(taskMenu);
  //
  //    taskMenu.add(new Menu("등록", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        taskAddHandler.execute(); 
  //      }});
  //    taskMenu.add(new Menu("목록") {
  //      @Override
  //      public void execute() {
  //        taskListHandler.execute(); 
  //      }});
  //    taskMenu.add(new Menu("상세보기") {
  //      @Override
  //      public void execute() {
  //        taskDetailHandler.execute(); 
  //      }});
  //    taskMenu.add(new Menu("변경", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        taskUpdateHandler.execute(); 
  //      }});
  //    taskMenu.add(new Menu("삭제", Menu.ENABLE_LOGIN) {
  //      @Override
  //      public void execute() {
  //        taskDeleteHandler.execute(); 
  //      }});
  //
  //
  //    return mainMenuGroup;
  //  }
}












