package com.min.app01.ex02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Divider {
  public double divide(int a, int b) {
    return a >= b ? (double) a / b : (double) b / a;
  }
}
