package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Project;
import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public abstract class AbstractTaskHandler implements Command {

  protected ProjectPrompt projectPrompt;

  public AbstractTaskHandler(ProjectPrompt projectPrompt) {
    this.projectPrompt = projectPrompt;
  }

  // 인스턴스 필드를 쓴다면 인스턴스 메서드로 리턴받는다.
  // 인스턴스 필드를 안쓰고 파라미터로 받은 값을 리턴만 한다. 그래서 static으로 만든다.
  // 
  public static void printTasks(Project project) {
    System.out.printf("%s:\n\n", project.getTitle());
    for (Task task : project.getTasks()) {
      System.out.printf("%d, %s, %s, %s, %s\n",
          task.getNo(), 
          task.getContent(), 
          task.getDeadline(), 
          getStatusLabel(task.getStatus()), 
          task.getOwner().getName());
    }
  }

  protected static String getStatusLabel(int status) {
    switch (status) {
      case 1: return "진행중";
      case 2: return "완료";
      default: return "신규";
    }
  }

  protected static int promptStatus() {
    return promptStatus(-1);
  }

  protected static int promptStatus(int status) {
    if (status == -1) {
      System.out.println("상태?");
    } else {
      System.out.printf("상태(%s)?\n", getStatusLabel(status));
    }
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    return Prompt.inputInt("> ");
  }



}





