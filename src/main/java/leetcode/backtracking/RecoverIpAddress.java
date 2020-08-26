package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @NAME: RecoverIpAddress
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION: 给定一串数组，复原所有的ip组合
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 **/
public class RecoverIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(), 0, 0, s);
        return list;

    }

    public static void main(String[] args) {
//        List<String> result = new RecoverIpAddress().getIps("123456");
//        System.out.println(result);
        List<String> result = new RecoverIpAddress().restoreIpAddresses("123456");
        System.out.println(result);
    }

    List<String> result = new ArrayList<>();
    List<String> getIps(String numbers) {
        int[] ips = new int[4];
        int[] values = new int[numbers.length()];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(numbers.substring(i, i + 1));
        }

        checkIfValid(values, 0, 0, ips);
        return result;
    }

    public void checkIfValid(int[] numbers, int start, int index, int[] ips) {
        if (ips.length == index && start == numbers.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ips.length; i++) {
                if (i != 3) {
                    sb.append(ips[i]).append('.');
                } else {
                    sb.append(ips[i]);
                }
            }
            result.add(sb.toString());
            return;
        }
        if (index >= ips.length || start >= numbers.length) {
            return;
        }
        // 一位数肯定可以做ip
        ips[index] = numbers[start];
        checkIfValid(numbers, start + 1, index + 1, ips);
        // 两位数不能是0开头
        if (start + 1 < numbers.length && numbers[start] != 0) {
            ips[index] = numbers[start] * 10 + numbers[start + 1];
            checkIfValid(numbers, start + 2, index + 1, ips);
        }
        // 三位数不能小于100，大于255
        if (start + 2< numbers.length
        && numbers[start] * 100 + numbers[start + 1] * 10 + numbers[start + 2] <= 255
        && numbers[start] * 100 + numbers[start + 1] * 10 + numbers[start + 2] >= 100) {
            ips[index] = numbers[start] * 100 + numbers[start + 1] * 10 + numbers[start + 2];
            checkIfValid(numbers, start + 3, index + 1, ips);
        }
    }

    /**
     *
     * @param list 记录ip组合结果
     * @param stringBuilder 记录ip值
     * @param level 当前层数，最大为4层
     * @param index 字符串当前位置
     */
    public void backtrack(List<String> list, StringBuilder stringBuilder, int level, int index, String s) {
        //结束条件
        //成功获取到ip组合，添加到结果集
        if (level == 4 && index == s.length()) {
            list.add(stringBuilder.toString());
            return;
        }
        //不满足条件到情况，返回
        if (level > 4 || index > s.length()) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            //如果后续值长度超出了数组长度，则退出循环
            if (index + i > s.length()) {
                break;
            }
            int num = Integer.valueOf(s.substring(index, index + i));
            //满足条件的数组才能加入到ip字符串中
            if (i == 1 || (i == 2 && i >= 10 && i <= 99) || (i == 3 && i >= 100 && i <= 255)) {
                stringBuilder.append(num);
                //前三层字符串都要加上"."
                if (level < 3) {
                    stringBuilder.append(".");
                }
                //递归产生剩下的ip值
                backtrack(list, stringBuilder, level + 1, index + i, s);
                //按添加顺序倒序删除已添加的字符串
                if (level < 3) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                stringBuilder.delete(stringBuilder.length() - i, stringBuilder.length());
            }
        }
    }

}
