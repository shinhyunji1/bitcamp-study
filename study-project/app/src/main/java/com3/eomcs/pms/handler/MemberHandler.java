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

  public void detail () {
    System.out.println("[회원 상세보기]");
    int no = Prompt.inputInt("번호 : ");

    Member member = findByNo(no);

    if(member == null) {
      System.out.println("해당 번호의 회원은 없습니다.");
      return;
    }
    System.out.printf("이름 : %s\n", member.name);
    System.out.printf("이메일 : %s\n", member.email);
    System.out.printf("암호 : %s\n", member.password);
    System.out.printf("사진 : %s\n", member.photo);
    System.out.printf("전화 : %s\n", member.tel);
    System.out.printf("등록일 : %s\n", member.registeredDate);

  }
  /*
  int i 
  for(i = 0; i< this.size; i ++) {
    if(this.members[i].no == no)
      member = members[i]
          break;
  }

  if(i == this.size) {
    return;
  }
  System.out.printf("이름 : %s\n", members[i].name);
  System.out.printf("이메일 : %s\n", members[i].email);
   */

  public void update () {
    System.out.println("[회원 정보변경]");
    int no = Prompt.inputInt("번호 : ");

    Member member = findByNo(no);

    if(member == null) {
      System.out.println("해당 번호의 회원은 없습니다.");
      return;
    }

    /*
    String name = Prompt.inputString("이름(" + member.name + ")? ");
    member.email = Prompt.inputString("이메일? ");
    member.password = Prompt.inputString("암호? ");
    member.photo = Prompt.inputString("사진? ");
    member.tel = Prompt.inputString("전화? ");
     */

    String label = String.format("이름(%s) : \n", member.name);
    String name = Prompt.inputString(label);

    label = String.format("암호(%s) : \n", member.password);
    String password = Prompt.inputString(label);

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N)");
    if(input.equalsIgnoreCase("N") || input.length() == 0) {
      System.out.println("해당 회원정보 변경은 취소됐습니다.");
      return;
    }

    member.name = name;
    member.password = password;
    System.out.println("해당 회원정보는 변경됐습니다.");
  }

  public void delete() {
    System.out.println("[회원 정보삭제]");
    int no = Prompt.inputInt("번호 : ");

    //Member member = null;
    int memberIndex = indexOf(no);//0부터 유효하기 때문에 못찾았다면 -1로 저장하기

    //for문으로 배열 최대길이까지 실행한다.
    //만약 배열 멤버의 번호와 사용자 입력 받은 번호랑 같다면
    //i는 memberIndex라는 변수에 대입한다.

    //위 for문을 다 돌고도 맞지 않는 번호라면
    //if문으로 실행
    //memberIndex가 -1이라면 해당 번호의 회원은 없다라고 출력한다.
    if(memberIndex == -1) {
      System.out.println("해당 번호의 회원은 없습니다.");
      return;
    }
    //위 update랑 똑같다.
    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N)");
    if(input.equalsIgnoreCase("N") || input.length() == 0) {
      System.out.println("해당 회원정보 삭제은 취소됐습니다.");
      return;
    }

    //이제 삭제가 되고 나머지 정보를 출력하는 것
    //i번을 삭제할때 뒤에서 앞으로 한칸씩 땡긴다.
    //for문으로 지울 번호의 뒷번호가 앞으로 오게금 초기값, 최대 길이까지 반복실행한다.
    for(int i = memberIndex + 1; i < this.size; i++) {
      this.members[i - 1] = this.members[i];
    }
    this.members[--this.size] = null;
    //하나씩 앞으로 이동했기 때문에 마지막 인덱스는 없긴때문에 null로 대입한다.



    System.out.println("게시글을 삭제하였습니다.");
  }

  private Member findByNo(int no) {//멤버 회원 정보를 찾아서 리턴
    for (int i = 0; i < this.size; i++) {
      if(this.members[i].no == no) {
        return this.members[i];
      }
    }
    return null;//못찾으면 리턴
  }

  private int indexOf (int no) {//객체를 리턴하는게 아니라 이것의 인덱스는 int 타입으로 찾아라
    for (int i = 0; i < this.size; i++) {
      if(this.members[i].no == no) {
        return i;
      }
    }
    return -1;
  }

}
