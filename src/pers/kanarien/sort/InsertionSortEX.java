package pers.kanarien.sort;
import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 插入排序改(InsertionSortEX):
 * 原理并没有变化，同样是往已经有序的(左侧)数组中插入未排序的数，
 * 改进的地方在于当为插入的数腾出空间时，不是一一交换而是大的数往右移，使减少一半访问数组的次数。
 * 
 * 该算法需要一个哨兵放在数组最左端来防止越界，
 * 下面采用了先找出最小值来放置最左端的方法。
 * 
 * 时间复杂度O(N^2)
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月8日 下午3:33:39
 */
public class InsertionSortEX implements Sortable{

    @Override
    public void sort(int[] array) {
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[min] > array[i]) {
                min = i;
            }
        }
        if (min != 0) {
            exchange(array, 0, min);
        } 
        for (int i = 2; i < array.length; i++) {
            int j = i;
            int temp = array[i];
            if (array[i] < array[i - 1]) {
                do {
                    j--;
                    array[j + 1] = array[j];
                } while (temp < array[j - 1]);
            }
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        testCase(new InsertionSortEX(), 300);
    }
}
