// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json;

import java.sql.Date;
import com.google.gson.Gson;

public class Exam0110 {
  public static void main(String[] args) {

    // 1) 객체 준비
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("111");
    m.setPhoto("hong.gif");
    m.setTel("010-0000-0000");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));

    Gson gson = new Gson();
    String jsonStr = gson.toJson(m);

    System.out.println(jsonStr);
  }
}

//JSON 객체 형식 - {객체 정보}
//=> [{"프로퍼티명" : 값, "프로퍼티명" : 값, ...},