package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class IsValid {

    //    验证
    public static void main(String[] args) {
        System.out.println(isValid1("()[]{}"));
        System.out.println(isValid1("([)]"));
        System.out.println(isValid1("()}"));
    }

    //方式一 效率低
    public static boolean isValid(String s) {
        //用映射关系，记录匹配
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (map.containsKey(c)) {
                //左括号
                stack.push(c);
            } else {
                //右括号
                if (stack.empty()) {
                    return false;
                }
                char top = stack.peek();
                if (!map.get(top).equals(c)) {
                    return false;
                }
                //取出栈顶元素，取出左括号，已被抵消
                stack.pop();
            }
        }
        if (!stack.empty()) {
            return false;
        }

        return true;
    }

    //方式二  效率高
    public static boolean isValid1(String s) {
        //创建一个Stack
        Stack<Character> stack = new Stack<>();
        //遍历给定的S，转换成char数组
        for (char c : s.toCharArray()) {
            //如果第一个出现左括号，就将右括号存入
            if (c == '(') {
                stack.push(')');
                //如果出现做中括号，就将右中括号存入
            } else if (c == '[') {
                stack.push(']');
                //如果出现左大括号，就将右中括号存入
            } else if (c == '{') {
                stack.push('}');
                //如果stack为空，或者c不等于栈中第一个元素。返回false
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        //如果为空，返回true
        return stack.empty();
    }
}
