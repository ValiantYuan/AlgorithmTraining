package leetcode.backtracking;

import org.apache.tools.ant.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NumberToAplhabet
 * @Description: 1，2 。。。26,分别代表a,b,c ... z, 给定一个数组字符串，解析可能代表的所有字母组合
 * @Author: YuanQi
 * @Date: 2020/2/21
 */
public class NumberToAlphabet {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 2, 0, 2, 3};
        new NumberToAlphabet().addResult(numbers, new StringBuilder(), 0);
        System.out.println(result);
    }

    char[] alphabets = new char[27];
    {
        for (int i = 1; i < alphabets.length; i++) {
            alphabets[i] = (char)('a' + (i - 1));
        }
    }

    static List<String> result = new ArrayList<>();

    public void addResult(int[] numbers, StringBuilder str, int pos) {
        if (pos >= numbers.length) {
            result.add(str.toString());
            return;
        }
        if (numbers[pos] == 0) {
            return;
        }

        addResult(numbers, str.append(alphabets[numbers[pos]]), pos + 1);
        // 回溯
        str.deleteCharAt(str.length() - 1);
        if( (pos + 1) < numbers.length
            && (numbers[pos] * 10 + numbers[pos + 1]) <= 26) {
            addResult(numbers, str.append(alphabets[numbers[pos] * 10 + numbers[pos + 1]]), pos + 2);
            // 回溯
            str.deleteCharAt(str.length() - 1);
        }
        return;
    }





}
