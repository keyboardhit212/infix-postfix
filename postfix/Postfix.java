package postfix;

import operator.Operator;
import postfix.utils.PostfixUtils;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    private String expression;
    private StringBuilder newExpression = new StringBuilder();

    public Postfix(String expression) {
        this.expression = PostfixUtils.spaceOut(expression);
        initialize();
    }

    private void initialize() {
        Scanner token = new Scanner(this.expression);
        Stack<String> operatorStack = new Stack<>();
        while (token.hasNext()) {
            String currentCharacter = token.next();
            switch (currentCharacter) {
                case "^":
                    operatorStack.push(currentCharacter);
                    break;
                case "+": case "-":
                case "*": case "/":
                    Operator currentOperator = Operator.which(currentCharacter);
                    while (!operatorStack.isEmpty() && currentOperator.getPrecedence() <= Operator.which(operatorStack.peek()).getPrecedence()) {
                        newExpression.append(operatorStack.pop() + " ");
                    }
                    operatorStack.push(currentOperator.getSymbol());
                    break;
                case "(":
                    operatorStack.push(currentCharacter);
                    break;
                case ")":
                    while (!operatorStack.empty() && !operatorStack.peek().equals("(") ) {
                        newExpression.append(operatorStack.pop() + " ");
                    }
                    operatorStack.pop();
                    break;
                default:
                    newExpression.append(currentCharacter + " ");
            }
        }
        while (!operatorStack.isEmpty()) {
            newExpression.append(operatorStack.pop() + " ");
        }
    }

    @Override
    public String toString() {
        return this.newExpression.toString();
    }
}
