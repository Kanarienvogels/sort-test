package pers.kanarien.sort;

import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 插入排序(InsertionSort):
 * 将数组中的未排序的数插入到已经有序的(左侧)数组中，同时为插入的数腾出空间，
 * 即比当前数要大的数在插入前都要往右移(这里的实现是一一交换)。
 * 
 * 插入排序非常适合那些需要排序的数组很小或者数组本身部分有序的情况，
 * 在这两种情况下，插入排序比很多排序都要快。
 * 
 * 最好的情况下交换次数为0，比较次数为N-1
 * 最坏的情况下交换次数为N(N-1)/2，比较次数为N(N-1)/2
 * 平均交换次数约为 (N^2)/4，平均比较次数约为 (N^2)/4
 * 时间复杂度O(N^2)
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月8日 下午3:04:13
 */
public class InsertionSort implements Sortable{

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    exchange(array, j, j - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        testCase(new InsertionSort(), 300);
    }
}
