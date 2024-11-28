package com.min.app02.ex01;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component

@RequiredArgsConstructor
//@AllArgsConstructor // Calculator(Adder, Subtractor, Multiplier, Divider)
@ToString


public class Calculator {
  private final String brand = "필립스";
  private final Adder module1;
  private final Subtractor module2;
  private final Multiplier module3;
  private final Divider module4;
}
