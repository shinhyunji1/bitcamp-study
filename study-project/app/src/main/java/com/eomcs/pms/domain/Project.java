package com.eomcs.pms.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {

  private static final long serialVersionUID = 1L;

  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members;
  private List<Task> tasks = new ArrayList<>();

  @Override
  public String toString() {
    return "Project [no=" + no + ", title=" + title + ", content=" + content + ", startDate="
        + startDate + ", endDate=" + endDate + ", owner=" + owner + ", members=" + members
        + ", tasks=" + tasks + "]";
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public List<Member> getMembers() {
    return members;
  }
  public void setMembers(List<Member> members) {
    this.members = members;
  }
  public List<Task> getTasks() {
    return tasks;
  }
  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  // 리팩토링
  // 필드, 인스턴스로 쓰지 않고 리턴하는 메서드는 static으로 만든다.
  // 현재 프로젝트의 멤버 이름을 문자열로 리턴한다.
  // 그리고 project 도메인으로 이동한다.
  // 그러면서 public 으로 변경
  // 위에 멤버가 있으므로 매개변수 필요없음
  // if 문으로 조건문 활용
  public String getMemberNames() {
    if (this.members == null) {
      return "";
    }// 그냥 빈문자열로 준다.
    StringBuilder names = new StringBuilder();
    for (Member member : this.members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  //프로젝트 정보에서 특정 작업을 조회하는 메서드를 이동한다.
  //프로젝트 클래스로 이동
  public Task findTaskByNo(int taskNo) {
    for (Task task : this.tasks) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }

}
