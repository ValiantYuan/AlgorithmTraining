package leetcode;

import java.util.HashSet;

/**
 * @NAME: IsHappy
 * @USER: valiant
 * @DATE: 2019-10-18
 * @DESCRITION: https://leetcode-cn.com/problems/happy-number/
 **/
public class IsHappy {
    public boolean isHappy(int n) {
        //用HashSet来判断是否进入循环，一旦出现了曾经出现过的数，说明开始循环
        HashSet<Integer> set = new HashSet<>();
        if (n <= 0) {
            return false;
        }
        int newValue = n;
        int count = 0;
        while (true) {
            count++;
            //产生新值
            newValue = generateNewValue(newValue);
            if (newValue == 1) {
                return true;
            }
            if (set.contains(newValue)) {
                System.out.println("重复值为" + newValue + "计算次数为" + count);
                return false;
            }
            set.add(newValue);

        }
    }

    public int generateNewValue(int n) {
        int value = 0;
        //首先计算个位的平方
        value = (n % 10) * (n % 10);
        if (n < 10) {
            return value;
        }
        int level = 10;
        //大于等于10的数在循环中计算
        while(n / level > 0) {
            int cur = n / level % 10;
            value += cur * cur;
            //如果不判断level的范围，可能会溢出导致level值不准
            if (level > Integer.MAX_VALUE / 10) {
                break;
            }
            level *= 10;
        }
        return value;
    }

    public static void main(String[] args) {
        boolean value = new IsHappy().isHappy(1563712132);
        System.out.println(value);
    }

}
