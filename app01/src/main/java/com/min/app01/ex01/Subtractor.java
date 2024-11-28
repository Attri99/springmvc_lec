package com.min.app01.ex01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Subtractor {
  
  public int subtract(int a, int b) {
    return a >= b ? a-b : b-a;
  }
}
