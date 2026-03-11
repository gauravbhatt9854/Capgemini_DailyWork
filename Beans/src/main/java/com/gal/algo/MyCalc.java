package com.gal.algo;


import org.springframework.stereotype.Component;

@Component
public class MyCalc implements Calc {

    public MyCalc()
    {
        System.out.println("bean is creating");
    }
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
