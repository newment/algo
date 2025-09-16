package leetcode.N0001;

import cn.hutool.core.collection.EnumerationIter;
import leetcode.base.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 有效的括号
 * 描述:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。  有效字符串需满足：  左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 每个右括号都有一个对应的相同类型的左括号。
 * <a href="https://leetcode.cn/problems/valid-parentheses/">有效的括号</a>
 */
public class N0020 {

    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character pop;
            switch (c){
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            }
            else{
                if(!stack.isEmpty() && c == stack.peek()){
                   stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        N0020 name = new N0020();
        String parameter = "(";
        boolean ret = name.isValid(parameter);
        System.out.println(ret);
    }

}