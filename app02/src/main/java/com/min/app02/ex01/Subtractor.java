package com.min.app02.ex01;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Subtractor {
  
  public int subtract(int a, int b) {
    return a >= b ? a-b : b-a;
  }
}
