package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;
import com.eomcs.util.Prompt;

public class ProjectHandler {

  static final int MAX_LENGTH = 5;

  Project[] projects = new Project[MAX_LENGTH];
  int size = 0;

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add(MemberHandler memberHandler) {//변수를 꼭 넘겨야 한다.
    System.out.println("[프로젝트 등록]");

    Project project = new Project();

    //사용자의 입력을 받는 Prompt.inputString("만든이? ")을 String owner이라는 변수값으로 주고
    //이 변수값을 if문에서 MemberHandler에서 회원정보가 확인되는지 확인한다.
    //여기에 proeject.owner에 있는 정보와 MemberHandler에 있는 name 정보와 같다면 break를 건다.
    project.no = Prompt.inputInt("번호? ");
    project.title = Prompt.inputString("프로젝트명? ");
    project.content = Prompt.inputString("내용? ");
    project.startDate = Prompt.inputDate("시작일? ");
    project.endDate = Prompt.inputDate("종료일? ");


    //만든이에서 MemberHandler의 name 정보에서 조회한다.
    //조희를 할때 참일 동안 조건문을 반복한다고해서 while문을 사용

    while (true) {
      String name;
      String owner = Prompt.inputString("만든이? (취소: 빈 문자열)");//String타입의 변수를 선언하고
      //MemberHandler memberHandler;
      if (memberHandler.exist(owner)) {// 만약 그 답변이 MemberHandler에서 확인되는지 확인
        project.owner = owner;
        break;
      } else if(owner.length() == 0) {
        System.out.println("프로젝트 등록을 취소합니다.");
        return;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    String members = "";//쉼표로 member를 나열하기 위해 members로 선언과 동시에 초기화한다.
    while (true) {
      String member = Prompt.inputString("팀원? (완료: 빈 문자열)");//String 타입의 member이라는 변수명으로 선언
      if (memberHandler.exist(member)) {//exist 메서드로 MemberHandler에 있는 회원정보와 일치한지 확인
        if(members.length() > 0) {//member이 아닌 members로 쓰는 이유는?
          //이미 회원정보와 일치하고 난 뒤 알 수 있는 members이기 때문에 
          members += ",";
        }
        members += member;//같다면 쉼표로 구분해서 member를 나열한다.
        continue;// 나열한 것을 members에 저장하기 위해 String members;으로 선언해준다.
        //계속 반복하기 위해서 continue를 사용
      } else if (member.length() == 0) {//만약 member라는 변수값에 길이가 0이라면 break를 건다.
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }
    project.members = members;//마지막임)쉼표로 구분한 members를 project.members에 대입한다.

    this.projects[this.size++] = project;
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[프로젝트 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %s, [%s]\n",
          this.projects[i].no, 
          this.projects[i].title, 
          this.projects[i].startDate, 
          this.projects[i].endDate, 
          this.projects[i].owner,
          this.projects[i].members);
    }
  }

  public void detail () {
    System.out.println("[프로젝트 상세보기]");
    int no  = Prompt.inputInt("번호? ");

    Project project = null;
    for (int i = 0; i < size; i++) {
      if(projects[i].no == no) {
        project = projects[i];
        break;//끝내는 이유? for문을 사용하여 다음 if문을 사용한다.
      }
    }

    if(project == null) {
      System.out.println("해당 번호의 프로젝트는 없습니다.");
      return;
    }

    System.out.printf("제목 : %s\n", project.title);
    System.out.printf("시작일 : %s\n", project.startDate);
    System.out.printf("종료일 : %s\n", project.endDate);
    System.out.printf("만든이 : %s\n", project.owner);
    System.out.printf("팀원 : %s\n", project.members);


  }

  public void update () {
    System.out.println("[프로젝트 상세보기]");
    int no  = Prompt.inputInt("번호? ");

    Project project = null;
    for (int i = 0; i < size; i++) {
      if(projects[i].no == no) {
        project = projects[i];
        break;//끝내는 이유? for문을 사용하여 다음 if문을 사용한다.
      }
    }

    if(project == null) {
      System.out.println("해당 번호의 프로젝트는 없습니다.");
    }

    String label = String.format("제목(%s) : \n", project.title);
    String title = Prompt.inputString(label);
    label = String.format("만든이(%s) : \n", project.owner);
    String owner = Prompt.inputString(label);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
    if(input.equalsIgnoreCase("N") || input.length() == 0) {
      System.out.println("해당 번호의 프로젝트 변경은 취소됐습니다.");
      return;
    }
    project.title = title;
    project.owner = owner;
    System.out.println("해당 번호의 프로젝트 변경됐습니다.");
  }

  public void delete() {
    System.out.println("[프로젝트 삭제]");
    int no = Prompt.inputInt("번호 : ");

    int projectIndex = -1;
    for (int i = 0; i < size; i++) {
      if (projects[i].no == no) {
        projectIndex = i;
        break;
      }
    }
    if(projectIndex == -1) {
      System.out.println("해당 번호의 프로젝트가 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)");
    if(input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("프로젝트 삭제를 취소하였습니다.");
      return;
    }

    for (int i = projectIndex + 1; i < this.size; i++) {
      this.projects[i - 1] = this.projects[i];
    }
    this.projects[--this.size] = null;
    System.out.println("프로젝트 삭제하였습니다.");
  }
}























