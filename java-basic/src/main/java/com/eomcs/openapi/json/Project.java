package com.eomcs.openapi.json;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Project{
  private int no;
  private String title;
  private String content;
  private Date startDate;
  private Date endDate;
  private Member owner;
  private List<Member> members = new ArrayList<>(); // 나중에 버리더라고 빈 리스트 만든다.
  private List<Task> tasks = new ArrayList<>(); // 테스크는 빈걸 만든다.

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

  public String getMemberNames() {
    if (this.members == null) {
      return "";
    }

    StringBuilder names = new StringBuilder();
    for (Member member : this.members) {
      if (names.length() > 0) {
        names.append(",");
      }
      names.append(member.getName());
    }
    return names.toString();
  }

  public Task findTaskByNo(int taskNo) {
    for (Task task : this.tasks) {
      if (task.getNo() == taskNo) {
        return task;
      }
    }
    return null;
  }
}