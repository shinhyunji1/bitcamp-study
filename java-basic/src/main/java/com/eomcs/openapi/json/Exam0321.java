// 객체 --> JSON 문자열 : 객체의 필드 값을 json 형식의 문자열로 만들기
package com.eomcs.openapi.json;

import java.lang.reflect.Type;
import java.util.Collection;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Exam0321 {
  public static void main(String[] args) {

    String jsonStr = "[{\"no\":101,\"name\":\"홍길동\"},{\"no\":102,\"name\":\"임꺽정\"},{\"no\":103,\"name\":\"안창호\"}]";


    // Exam0320의 코드를 익명 클래스를 이용하여 간결하게 정리한 것이다.
    Type collectionType = new TypeToken<Collection<Member>>(){}.getType();

    Collection<Member> list = new Gson().fromJson(jsonStr, collectionType);

    for (Member m : list) {
      System.out.println(m);
    }
  }
}

