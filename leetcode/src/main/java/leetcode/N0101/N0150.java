package leetcode.N0101;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

/**
 * 逆波兰表达式求值
 * 描述:给你一个字符串数组 tokens, 表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。  注意：  有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <a href="https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/">逆波兰表达式求值</a>
 */
@SuppressWarnings("all")
public class N0150 {

    /**
     * 方法1 利用栈
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            Integer b;
            Integer a;
            switch (token) {
                case "+" -> {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public Integer operate(Integer num1, Integer num2, String operate) {
        return switch (operate) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
    }

    private Integer index;

    public Integer evalRPN1(String[] tokens) {
        index = tokens.length - 1;
        return eval(tokens);
    }

    public Integer eval(String[] tokens) {
        try {
            return Integer.parseInt(tokens[index]);
        } catch (NumberFormatException e) {
            int cur = index;
            index--;
            int b = eval(tokens);
            index--;
            int a = eval(tokens);
            return operate(a, b, tokens[cur]);
        }
    }


    @Test
    public void test() {
        N0150 name = new N0150();
        String[] parameter = {"4", "13", "5", "/", "+"};
        int ret = name.evalRPN1(parameter);
        System.out.println(ret);
    }

}