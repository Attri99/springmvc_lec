package com.min.app01.ex02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Multiplier {
  public int multiply(int... args) {
    int product = 1;
    for(int i = 0; i < args.length; i++) {
      product *= args[i];
    }
    return product;
  }
}
