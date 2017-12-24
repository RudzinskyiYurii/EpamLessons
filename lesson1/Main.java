package com.lesson1;

import com.lesson1.ex1.Fibonacci;
import com.lesson1.ex2.ex2_1.Sort;
import com.lesson1.ex2.ex2_2.CorrectNumbers;
import com.lesson1.ex2.ex2_3.SimpleDigits;
import com.lesson1.ex2.ex2_4.WithoutRemainder;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Fibonacci fib = new Fibonacci(10);
        System.out.println(fib);

        Sort sort = new Sort(new int [] {2,45,11,8,3});
        System.out.println(sort);

        CorrectNumbers corrN = new CorrectNumbers(new int[] {11111, 22222, 144588, 8812233});

        SimpleDigits simpD = new SimpleDigits(new int [] {11,45,2,8,3});

        WithoutRemainder withoutR = new WithoutRemainder(new int [] {11111, 22222, 44444, 8812233});

    }
}
