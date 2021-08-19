package com.eomcs.pms.handler;


public interface List {
  // 인터페이스의 메서드는 기본적으로 public이고 abstract 이다.
  void add(Object item);
  Object[] toArray();
  boolean remove(Object obj);
  int size();// 규칙 추가하기 -> ArrayList/LinkedList에 추가한다.
}









