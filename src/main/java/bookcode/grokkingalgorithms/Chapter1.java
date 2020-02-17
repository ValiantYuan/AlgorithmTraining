package bookcode.grokkingalgorithms;

/**
 * @ClassName Chapter1
 * @Description: TODO
 * @Author: YuanQi
 * @Date: 2019/12/10
 */
public class Chapter1 {


    private final String name;
    {
        name = "yuanqi";
    }

    /**
     * 二分查找
     * @param array
     * @param target
     * @return
     */
    public boolean binarySearch(int[] array, final int target) {
        int low = 0;
        int high = array.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (target == array[mid]) {
                return true;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            }
        }
        return false;
    }



}
