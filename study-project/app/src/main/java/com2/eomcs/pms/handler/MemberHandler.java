package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Member;
import com.eomcs.util.Prompt;

public class MemberHandler {
  static final int MAX_LENGTH = 5;

  // Member 인스턴스의 주소를 저장할 레퍼런스를 3개 생성한다.
  Member[] members = new Member[MAX_LENGTH];
  int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add() {
    System.out.println("[회원 등록]");

    // 새 회원 정보를 담을 변수를 준비한다.
    // 낱 개의 변수가 아니라 Member에 정의된 대로 묶음 변수를 만든다.
    Member member = new Member();

    member.no = Prompt.inputInt("번호? ");
    member.name = Prompt.inputString("이름? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
    member.registeredDate = new Date(System.currentTimeMillis());

    this.members[this.size++] = member; //this에는 주소번지를 받는데 그렇게 값을 집어넣는다.
  }

  //다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[회원 목록]");
    for (int i = 0; i < this.size; i++) {//this에느,ㄴ 주소를 주고
      System.out.printf("%d, %s, %s, %s, %s\n", 
          this.members[i].no, 
          this.members[i].name, 
          this.members[i].email, 
          this.members[i].tel, 
          this.members[i].registeredDate);
    }

  }

  boolean exist (String name) {// 참거짓으로 정보를 확인하고 있다면 true, 없다면 false
    for(int i = 0; i < this.size; i++) {
      if(this.members[i].name.equals(name)) {//for문으로 계속 돌리다가
        //만약 members[i].name과 외부의 변수 값을 받은 것과 같다면 true로 리턴, 아니면 false
        return true;
      }
    }
    return false;
  }
}