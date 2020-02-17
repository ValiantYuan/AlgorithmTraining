package bookcode.grokkingalgorithms;

import java.util.Arrays;

/**
 * @ClassName Chapter4
 * @Description: TODO
 * @Author: YuanQi
 * @Date: 2019/12/25
 */
public class Chapter4 {

    public void quickSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public int partition(int[] array, int low, int high) {
        int j = low;
        int partition = array[high];
        for (int i = low; i < high; i++) {
            if (array[i] <= partition) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                j++;
            }
        }
        int tmp = array[high];
        array[high] = array[j];
        array[j] = tmp;
        return j;
    }

    public void sort(int array[], int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(array, low, high);
        sort(array, low, pivot - 1);
        sort(array, pivot + 1, high);
    }

    public static void main(String[] args) {
        int[] array = {12, 4, 5, 3, 2, 15, 42, 17, 7, 51};
        new Chapter4().quickSort(array);
        System.out.println(Arrays.toString(array));
    }


}
