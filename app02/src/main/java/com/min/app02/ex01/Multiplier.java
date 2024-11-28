package com.min.app02.ex01;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Multiplier {
  public int multiply(int... args) {
    int product = 1;
    for(int i = 0; i < args.length; i++) {
      product *= args[i];
    }
    return product;
  }
}
