package com.example.rpncalc;

/**
 * Solves Reverse Polish Notation expressions
 *
 * @author ahuvacheifetz
 */

import java.util.Scanner;

public class rpnCalc {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String expression = "x";

        while (expression.length() > 0) {
            System.out.println("Enter in an expression comprising of numbers and the following operators: +,/,-,*\n");
            expression = scan.nextLine();
            if (expression.equals("")) break;
            System.out.println(RPN.evaluate(expression));
        }
        System.out.println("All done");
    }

}



