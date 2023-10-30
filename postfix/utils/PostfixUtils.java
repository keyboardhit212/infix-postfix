package postfix.utils;

import java.util.Stack;

public final class PostfixUtils {

    private PostfixUtils() {}

    public static boolean isBalanced(String expression) {
        boolean result = true;
        int index = 0;
        Stack<Character> parenthesisStack = new Stack<>();
        while (result && index < expression.length()) {
            char token = expression.charAt(index);
            switch (token) {
                case '[': case '{': case '(':
                    parenthesisStack.push(token);
                    break;
                case ']': case '}': case ')':
                    if (parenthesisStack.isEmpty())
                        result = false;
                    else {
                        char opening = parenthesisStack.pop();
                        if (!isPair(opening, token))
                            result = false;
                    }
                    break;
            }
            index++;
        }
        return result;
    }

    public static String spaceOut(String expression) {
        StringBuilder newExpression = new StringBuilder();
        StringBuilder operandHolder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char nextCharacter = expression.charAt(i);
            if (isOperand(nextCharacter)) {
                operandHolder.append(nextCharacter);
            } else if (isOperator(nextCharacter)) {
                if (!operandHolder.isEmpty())
                    newExpression.append(operandHolder.toString() + " ");
                newExpression.append(nextCharacter + " ");
                operandHolder = new StringBuilder();
            }
        }
        newExpression.append(operandHolder.toString());
        return newExpression.toString();
    }

    private static boolean isPair(char opening, char closing) {
        return  ((opening == '(' && closing == ')') ||
                (opening == '{' && closing == '}') ||
                (opening == '[' && closing == ']'));
    }

    private static boolean isOperand(char character) {
        boolean result = true;
        if (isOperator(character))
            result = false;
        return result;
    }

    public static boolean isOperator(char character) {
        boolean result = false;
        switch (character) {
            case '+': case '-':
            case '*': case '/':
            case '(': case ')':
                result = true;
                break;
        }
        return result;
    }

    public static boolean isOperator(String character) {
        boolean result = false;
        switch (character) {
            case "+": case "-":
            case "*": case "/":
            case "(": case ")":
                result = true;
                break;
        }
        return result;
    }
}
