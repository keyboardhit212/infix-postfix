package operator;

public enum Operator {
    ADDITION(1, "+"),
    SUBTRACTION(1, "-"),
    MULTIPLICATION(2, "*"),
    DIVISION(2, "/"),
    OPEN_PARENTHESIS(0, "("),
    CLOSED_PARENTHESIS(0, ")"),
    EXPONENT(3, "^");

    public static Operator which(String symbol) throws RuntimeException {
        switch (symbol) {
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "*":
                return MULTIPLICATION;
            case "/":
                return DIVISION;
            case "(":
                return OPEN_PARENTHESIS;
            case ")":
                return CLOSED_PARENTHESIS;
            case "^":
                return EXPONENT;
            default:
                throw new RuntimeException("Invalid Operator");
        }
    }

    Operator(int precedence, String symbol) {
        this.precedence = precedence;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getPrecedence() {
        return this.precedence;
    }

    private int precedence;
    private String symbol;
}
