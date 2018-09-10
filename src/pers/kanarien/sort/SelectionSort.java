package pers.kanarien.sort;

import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 选择排序(SelectionSort)：
 * 找到数组中最小的数，然后和第一个数交换。
 * 接着在剩余的数中找出最小的数，然后与第二个数交换，如此反复，共N趟。
 * 
 * 最好和最坏的情况下，交换次数为N，比较次数约为 (N^2)/2
 * 是少数交换次数达到线性级别的排序算法
 * 时间复杂度为O(N^2)
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月8日 下午2:24:57
 */
public class SelectionSort implements Sortable{

    
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            exchange(array, i, min);
        }
    }

    public static void main(String[] args) {
        testCase(new SelectionSort(), 100);
    }
}
