package com.min.app02.ex01;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
@ToString
public class Adder {
  
  public int add(int...args) {
    int total = 0;
    for(int i=0; i < args.length; i++) 
       total += args[i];
    return total;  
   }
}