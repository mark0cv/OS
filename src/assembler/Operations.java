package assembler;

import java.util.Stack;

public class Operations {
    private static Stack<String> stack = new Stack<>();

    public static void pushToStack(String value) {
        stack.push(value);
    }

    public static String popFromStack() {
        return stack.pop();
    }

    public static void addValues() {
        String a = stack.pop();
        String b = stack.pop();
        stack.push(String.valueOf(Integer.parseInt(a) + Integer.parseInt(b)));
    }

    public static void subtractValues() {
        String a = stack.pop();
        String b = stack.pop();
        stack.push(String.valueOf(Integer.parseInt(a) - Integer.parseInt(b)));
    }

    public static void multiplyValues() {
        String a = stack.pop();
        String b = stack.pop();
        stack.push(String.valueOf(Integer.parseInt(a) * Integer.parseInt(b)));
    }

    public static void divideValues() {
        String a = stack.pop();
        String b = stack.pop();
        stack.push(String.valueOf(Integer.parseInt(a) / Integer.parseInt(b)));
    }

    public static void incrementValue() {
        String a = stack.pop();
        stack.push(String.valueOf(Integer.parseInt(a) + 1));
    }

    public static void decrementValue() {
        String a = stack.pop();
        stack.push(String.valueOf(Integer.parseInt(a) - 1));
    }
}
