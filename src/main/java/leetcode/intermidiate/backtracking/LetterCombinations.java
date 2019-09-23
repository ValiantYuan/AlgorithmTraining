package leetcode.intermidiate.backtracking;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @NAME: LetterCombinations
 * @USER: valiant
 * @DATE: 2019-09-22
 * @DESCRITION: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 **/
public class LetterCombinations {

    private Map<Character, ArrayList<Character>> numsMap = new HashMap<>();


    /**
     * 由于采用的是递归的思想，所以回溯法一般不需要循环，但是在某一个值有多种选择时，要使用循环，且需要恢复到原状
     * @param length
     * @param pos
     * @param stringBuffer
     * @param result
     * @param nums
     */
    public void backtrack(int length, int pos, StringBuffer stringBuffer, ArrayList<String> result, char[] nums) {
        if (length == pos) {
            result.add(stringBuffer.toString());
        }
        else {
            char num = nums[pos];
            ArrayList<Character> letters = numsMap.get(num);
            for (int j = 0; j < letters.size(); j++) {
                //把当前字符加入到字符串中
                stringBuffer.append(letters.get(j));
                //递归执行下一层结果
                backtrack(length, pos + 1, stringBuffer, result, nums);
                //恢复原状
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        init();
        char[] nums = digits.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int length = nums.length;
        backtrack(length, 0, stringBuffer, result, nums);
        return result;
    }

    private void init() {
        char[][] letters = {{'a', 'b', 'c'},{'d', 'e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        char[] nums = {'2','3','4','5','6','7','8','9'};
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], addToList(letters[i]));
        }
    }

    private ArrayList<Character> addToList(char[] chars) {
        ArrayList<Character> list = new ArrayList<>();
        for (char letter: chars
             ) {
            list.add(letter);
        }
        return list;
    }

    public static void main(String[] args) {
        String input = "23";
        System.out.println(new LetterCombinations().letterCombinations(input));

    }
}
