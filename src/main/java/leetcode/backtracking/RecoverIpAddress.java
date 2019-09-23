package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @NAME: RecoverIpAddress
 * @USER: valiant
 * @DATE: 2019-09-23
 * @DESCRITION: 给定一串数组，复原所有的ip组合
 **/
public class RecoverIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(""), 0, 0, s);
        return list;

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
