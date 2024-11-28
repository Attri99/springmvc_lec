package com.min.app01.ex03;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

@NoArgsConstructor // Calculator()
@AllArgsConstructor // Calculator(Adder, Subtractor, Multiplier, Divider)
@Getter
@Setter

public class Calculator {
  private String brand = "필립스";
  private Adder module1 = new Adder();
  private Subtractor module2 = new Subtractor();
  private Multiplier module3 = new Multiplier();
  private Divider module4 = new Divider();
}
