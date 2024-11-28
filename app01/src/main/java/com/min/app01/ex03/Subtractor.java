package com.min.app01.ex03;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class Subtractor {
  
  public int subtract(int a, int b) {
    return a >= b ? a-b : b-a;
  }
}
