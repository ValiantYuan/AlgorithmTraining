package bookcode.grokkingalgorithms;

import java.util.Arrays;

/**
 * @ClassName Chapter2
 * @Description: TODO
 * @Author: YuanQi
 * @Date: 2019/12/12
 */
public class Chapter2 {
    public static void main(String[] args) {
        int[] array = {19, 3, 56, 34, 2, 5, 1};
        Arrays.stream(new Chapter2().selectionSort(array)).forEach(i -> System.out.println(i));
    }

    public int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = findSmallest(i, array);
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }

    public int findSmallest(int start, int[] array) {
        int minIndex = start;
        for (int i = start + 1; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }
        return minIndex;
    }


}
