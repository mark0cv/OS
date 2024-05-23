package assembler;

public enum OperationType {
    ADD,SUBTRACT,MULTIPLY,DIVIDE,PUSH,POP,INCREMENT,DECREMENT;

    public static OperationType fromString(String op){
        switch (op.toUpperCase()) {
            case "ADD":
                return ADD;
            case "SUB":
                return SUBTRACT;
            case "MUL":
                return MULTIPLY;
            case "DIV":
                return DIVIDE;
            case "PUSH":
                return PUSH;
            case "POP":
                return POP;
            case "INC":
                return INCREMENT;
            case "DEC":
                return DECREMENT;
            default:
                throw new IllegalArgumentException("Invalid operation: " + op);
        }
    }
}
