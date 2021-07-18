package com.eomcs.pms.domain;

import java.sql.Date;

public class Project {
  //Project에 정보를 저장할 메모리 설계
  public int no;
  public String title;
  public String content;
  public Date startDate;
  public Date endDate;
  public String owner;
  public String members;
}
