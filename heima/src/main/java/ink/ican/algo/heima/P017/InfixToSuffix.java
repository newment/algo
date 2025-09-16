package ink.ican.algo.heima.P017;

import java.util.ArrayDeque;

/**
 * 中缀表达式转后缀表达式
 */
public class InfixToSuffix {

    public static void main(String[] args) {

        System.out.println("(a+b)*c-d = " + infixToSuffix("(a+b)*c"));
        System.out.println("(a+b*c-d)*e = " + infixToSuffix("(a+b*c-d)*e"));
        System.out.println("a*(b+c) = " + infixToSuffix("a*(b+c)"));

    }

    public static int priority(char c) {
        switch (c) {
            case '*', '/' -> {
                return 2;
            }
            case '(' -> {
                return 0;
            }
            default -> {
                return 1;
            }
        }
    }

    public static String infixToSuffix(String exp) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+', '-', '*', '/' -> {
                    if(stack.isEmpty() || priority(c) > priority(stack.peek())){
                        stack.push(c);
                    }
                    else{
                        while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                            sb.append(stack.pop());
                        }
                        stack.push(c);
                    }
                }
                case '(' -> stack.push(c);
                case ')' -> {
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
