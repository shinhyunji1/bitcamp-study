// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json;

import java.lang.reflect.Type;
import java.util.Collection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Exam0322 {
  public static void main(String[] args) {

    String jsonStr = "[{\"no\":101,\"name\":\"홍길동\"},{\"no\":102,\"name\":\"임꺽정\"},{\"no\":103,\"name\":\"안창호\"}]";

    // Exam0321과 다른 방법으로 Type 객체를 얻기
    Type collectionType = TypeToken.getParameterized(Collection.class, Member.class).getType();
    // 타입 클래스에서 타입토큰의 getParameterized를 실행한다.
    // 실행할 때 , Collection의 class와 Member.class를 실행하는데 그 타입을 가져온다.

    Collection<Member> list = new Gson().fromJson(jsonStr, collectionType);

    for (Member m : list) {
      System.out.println(m);
    }
  }
}
