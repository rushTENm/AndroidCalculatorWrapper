package com.example.rusht.androidcalculatorwrapper;

import java.util.Stack;

public class Infix {
    char ch, topOp;
    Stack temp = new Stack();
    String result = "";

    public Infix(String strInfix) {
        for (int i = 0; i < strInfix.length(); i++) {
            ch = strInfix.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!temp.isEmpty() && (precede(ch) <= precede(temp.peek().toString().charAt(0)))) {
                        result += temp.pop().toString();
                    }
                    temp.push(ch);
                    break;
                case '(':
                    temp.push(ch);
                    break;
                case ')':
                    topOp = temp.pop().toString().charAt(0);
                    while (topOp != '(') {
                        result += topOp;
                        topOp = temp.pop().toString().charAt(0);
                    }
                    break;
                default:
                    result += ch;
                    break;
            }

        }
        while (!temp.isEmpty()) {
            result += temp.pop().toString();
        }
    }

    int precede(char op) {
        switch (op) {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    String getResult() {
        return result;
    }
}
