package com.example.rpncalc;

import java.util.Stack;

/**
 * This creates a calculator object that calculates reverse polish notation
 * expressions
 *
 * @author ahuvacheifetz
 */
public class RPN {

    public static String evaluate(String expression) {
        Stack<Double> stackNum = new Stack<>();
        String[] strExp = expression.split("\\s+");

        for (int i = 0; i < strExp.length; i++) {

            String value = strExp[i];
            if (!pushIfNumeric(value, stackNum)) {

                if (isOperation(value)) {
                    if (stackNum.size() < 2) {
                        return "syntax issue";
                    } else {
                        Double value1 = stackNum.pop();
                        Double value2 = stackNum.pop();
                        stackNum.push(operate(value1, value2, value.charAt(0)));
                    }

                } else {
                    return "Invalid input";
                }
            }
        }
        return String.format("%.2f", stackNum.pop());
    }

    private static boolean pushIfNumeric(String s, Stack<Double> stackNum) {
        try {
            Double dblNum = Double.parseDouble(s);
            stackNum.push(dblNum);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isOperation(String s) {
        if (s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {
            return true;
        } else {
            return false;
        }
    }

    private static Double operate(Double val1, Double val2, char operation) {
        Double retVal = null;
        switch (operation) {
            case '+':
                retVal = val2 + val1;
                break;
            case '-':
                retVal = val2 - val1;
                break;
            case '/':
                retVal = val2 / val1;
                break;
            case '*':
                retVal = val2 * val1;
                break;
        }
        return retVal;
    }
}


