package com.example.rusht.androidcalculatorwrapper;

import java.util.Stack;

public class Postfix {
    Stack<Integer> stckPostfix;
    char ch;
    int op1, op2, value;

    public Postfix(String strPostfix) {
        stckPostfix = new Stack();

        for (int i = 0; i < strPostfix.length(); i++) {
            ch = strPostfix.charAt(i);

            if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
                value = Character.getNumericValue(ch);
                stckPostfix.push(value);
            } else {
                op2 = Integer.valueOf(stckPostfix.pop().toString());
                op1 = Integer.valueOf(stckPostfix.pop().toString());

                switch (ch) {
                    case '+':
                        stckPostfix.push(op1 + op2);
                        break;
                    case '-':
                        stckPostfix.push(op1 - op2);
                        break;
                    case '*':
                        stckPostfix.push(op1 * op2);
                        break;
                    case '/':
                        stckPostfix.push(op1 / op2);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public int getValue() {
        return Integer.valueOf(stckPostfix.pop().toString());
    }
}
