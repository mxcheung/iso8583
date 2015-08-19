package com.maxcheung.generics;
public class GenericClass<T> {
  T ob;

  GenericClass(T o) {
    ob = o;
  }

  T getob() {
    return ob;
  }

  void showType() {
    System.out.println("Type of T is " + ob.getClass().getName());
  }
}
