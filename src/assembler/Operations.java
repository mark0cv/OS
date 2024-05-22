package asembler;

import java.util.Stack;

public class Operations {
    private static Stack<String>stack=new Stack<>();

    public static void push(String value){
        stack.push(value);
    }
    public static String pop(){
        return stack.pop();
    }
    public static void add(){
        String a=stack.pop();
        String b=stack.pop();
        Integer intA=Integer.parseInt(a);
        Integer intB=Integer.parseInt(b);
        Integer result=intA+intB;
        stack.push(String.valueOf(result));
    }

    public static void sub(){
        String a=stack.pop();
        String b=stack.pop();
        Integer intA=Integer.parseInt(a);
        Integer intB=Integer.parseInt(b);
        Integer result=intA-intB;
        stack.push(String.valueOf(result));
    }
    public static void mul(){
        String a=stack.pop();
        String b=stack.pop();
        Integer intA=Integer.parseInt(a);
        Integer intB=Integer.parseInt(b);
        Integer result=intA*intB;
        stack.push(String.valueOf(result));
    }
    public static void div(){
        String a=stack.pop();
        String b=stack.pop();
        Integer intA=Integer.parseInt(a);
        Integer intB=Integer.parseInt(b);
        Integer result=intA/intB;
        stack.push(String.valueOf(result));
    }
    public static void inc(){
        String a=stack.pop();
        Integer intA=Integer.parseInt(a);
        intA++;
        stack.push(String.valueOf(intA));
    }
    public static void dec(){
        String a=stack.pop();
        Integer intA=Integer.parseInt(a);
        intA--;
        stack.push(String.valueOf(intA));
    }
}
