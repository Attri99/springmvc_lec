package com.min.app02.ex01;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Divider {
  public double divide(int a, int b) {
    return a >= b ? (double) a / b : (double) b / a;
  }
}
