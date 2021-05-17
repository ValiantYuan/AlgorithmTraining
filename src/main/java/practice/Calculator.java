package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : yuanqi
 * @since : 2021/4/2
 */
public class Calculator {


    public static void main(String[] args) throws Exception {
        String expression = "11 + (2.3 - 2 / 4) * 2 + 2^2";
        System.out.println(new Calculator().calculate(expression.replaceAll(" ", "")));
    }


    Map<String, Operation> operations = Factory.getOperations();


    float calculate(String expression) throws Exception {
        Stack<Float> stack = new Stack<>();
        for (int i = 0; i < expression.length() - 1; ) {
            char c = expression.charAt(i);
            if (isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && isDigit(expression.charAt(i))) {
                    num.append(expression.charAt(i));
                    i++;
                }
                stack.push(Float.parseFloat(num.toString()));
            } else if (isOperand(c)) {
                Operation operation = operations.get(String.valueOf(c));
                i++;
                float calculate;
                if (expression.charAt(i) == '(') {
                    int start = i;
                    int level = 0;
                    while (expression.charAt(i) != ')' || level != 0) {
                        if (expression.charAt(i) == '(') {
                            level++;
                        }
                        if (expression.charAt(i) == ')') {
                            level--;
                            if (level == 0) {
                                break;
                            }
                        }
                        i++;
                    }
                    calculate = calculate(expression.substring(start + 1, i));
                    i++;
                } else {
                    StringBuilder num = new StringBuilder();
                    while (i < expression.length() && isDigit(expression.charAt(i))) {
                        num.append(expression.charAt(i));
                        i++;
                    }
                    calculate = Float.parseFloat(num.toString());
                }
                operation.calculate(stack, calculate);
            } else if (expression.charAt(i) == '(') {
                int start = i;
                int level = 0;
                while (expression.charAt(i) != ')' || level > 0) {
                    if (expression.charAt(i) == '(') {
                        level++;
                    }
                    if (expression.charAt(i) == ')') {
                        level--;
                        if (level == 0) {
                            break;
                        }
                    }
                    i++;
                }
                float calculate = calculate(expression.substring(start + 1, i));
                stack.push(calculate);
                i++;
            }

        }
        float sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    boolean isDigit(char c) {
        return (c <= '9' && c >= '0') || c == '.';
    }

    boolean isOperand(char c) {
        return operations.containsKey(String.valueOf(c));
    }


}

class Factory {
    static Map<String, Operation> getOperations() {
        Map<String, Operation> map = new HashMap<>();
        map.putIfAbsent("+", new OperationSum());
        map.putIfAbsent("-", new OperationMinus());
        map.putIfAbsent("*", new OperationMultiply());
        map.putIfAbsent("/", new OperationDivide());
        map.putIfAbsent("^", new OperationPow());
        return map;
    }
}


abstract class Operation {
    abstract void calculate(Stack<Float> stack, Float num) throws Exception;
}

class OperationSum extends Operation {
    @Override
    void calculate(Stack<Float> stack, Float num) {
        stack.push(num);
    }
}

class OperationMinus extends Operation {
    @Override
    void calculate(Stack<Float> stack, Float num) {
        stack.push(-num);
    }
}

class OperationDivide extends Operation {
    @Override
    void calculate(Stack<Float> stack, Float num) throws Exception {
        stack.push(stack.pop() / num);
    }
}

class OperationMultiply extends Operation {
    @Override
    void calculate(Stack<Float> stack, Float num) {
        stack.push(stack.pop() * num);
    }
}

class OperationPow extends Operation {
    @Override
    void calculate(Stack<Float> stack, Float num) {
        float tmp = stack.pop();
        int n = 1;
        float result = 1;
        while (n <= num) {
            n++;
            result *= tmp;
        }
        stack.push(result);
    }
}