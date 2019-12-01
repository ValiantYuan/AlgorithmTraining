package leetcode.simple;

/**
 * @ClassName ReverseInteger
 * @Description: TODO
 * @Author: YuanQi
 * @Date: 2019/11/29
 */
public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
            //首先取余
            int tmp = x % 10;
            //向右移以为
            x /= 10;
            //当反转当数字大于最大正直和最小负值 / 10 或者等于，但是取余当值超出了范围，则返回0
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            if ((rev == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10)
                    || (rev == Integer.MIN_VALUE / 10 && x < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            rev = rev * 10 + tmp;
        }
        return rev;
    }
}
