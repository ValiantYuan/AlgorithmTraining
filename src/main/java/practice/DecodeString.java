package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : yuanqi
 * @since : 2021/4/1
 * https://www.lintcode.com/problem/575/
 */
public class DecodeString {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new DecodeString().expressionExpand(s));
    }

    int ptr = 0;

    public String expressionExpand(String s) {
        Stack<String> stack = new Stack<>();
        while (ptr < s.length()) {
            Character character = s.charAt(ptr);
            if (character == '[') {
                stack.push(String.valueOf(character));
                ptr++;
            } else if (character <= '9' && character >= '0') {
                stack.push(getDigit(s));
            } else if (character == ']') {
                stack.push(getMakeupString(stack));
                ptr++;
            } else {
                stack.push(getString(s));
            }
        }
        List<String> list = new ArrayList<>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        StringBuilder result = new StringBuilder();
        list.forEach(str -> result.append(s));
        return result.toString();
    }

    public String getMakeupString(Stack<String> stack) {
        StringBuilder stringBuilder = new StringBuilder();
        getStringFromStackInGrace(stack, stringBuilder);
        stack.pop();
        stack.push(stringBuilder.toString());
        getStringFromStackInGrace(stack, stringBuilder);
        return stringBuilder.toString();
    }

    public void getStringFromStackInGrace(Stack<String> stack, StringBuilder stringBuilder) {
        while (!stack.peek().equals("[")) {
            String str = stack.pop();
            String num = stack.peek();
            if (num.equals("[")) {
                stringBuilder.append(str);
            } else {
                num = stack.pop();
                for (int i = 0; i < Integer.parseInt(num); i++) {
                    stringBuilder.append(str);
                }
            }
        }
    }

    public String getDigit(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (s.charAt(ptr) <= '9' && s.charAt(ptr) >= '0') {
            stringBuilder.append(s.charAt(ptr));
            ptr++;
        }
        return stringBuilder.toString();
    }

    public String getString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        while (s.charAt(ptr) >= 'a' && s.charAt(ptr) <= 'z' && ptr < s.length()) {
            stringBuilder.append(s.charAt(ptr));
            ptr++;
        }
        return stringBuilder.toString();
    }


}
