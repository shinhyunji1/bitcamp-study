// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json;

import com.google.gson.Gson;

public class Exam0220 {
  public static void main(String[] args) {
    String jsonStr = "[{\"no\":101,\"name\":\"홍길동\",\"email\":\"hong@test.com\",\"registeredDate\":\"9월 16, 2021\"},{\"no\":102,\"name\":\"임꺽정\",\"email\":\"leem@test.com\",\"registeredDate\":\"9월 16, 2021\"},{\"no\":103,\"name\":\"안창호\",\"email\":\"ahn@test.com\",\"registeredDate\":\"9월 16, 2021\"}]\n";

    Member[] members = new Gson().fromJson(jsonStr, Member[].class); // 배열의 타입을 지정한다.

    for (Member m : members) { // for문으로 다 돌린다.
      System.out.println(m);
    }
  }
}
