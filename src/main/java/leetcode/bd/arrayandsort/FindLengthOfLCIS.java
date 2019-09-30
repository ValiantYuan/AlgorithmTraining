package leetcode.bd.arrayandsort;

/**
 * @NAME: FindLengthOfLCIS
 * @USER: valiant
 * @DATE: 2019-09-28
 * @DESCRITION: 最长的单调递增数组的长度
 **/
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int maxLength = 1;
        int curLength = 1;
        //顺序遍历数组
        for (int i = 1; i < length; i++) {
            //如果递增，则curLength加1
            if (nums[i] > nums[i - 1]) {
                curLength++;
            } else {
                //没有递增，则更新maxLength和curLength继续循环
                maxLength = Math.max(maxLength, curLength);
                curLength = 1;
            }
        }
        //这里存在边界条件
        return maxLength >= curLength ? maxLength : curLength;
    }

    public static void main(String[] args) {
        int[] test = {1,3,5,7};
        int max = new FindLengthOfLCIS().findLengthOfLCIS(test);
        System.out.println(max);
    }
}
