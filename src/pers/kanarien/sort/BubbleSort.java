package pers.kanarien.sort;

import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;

/**
 * 冒泡排序：
 * 依次比较相邻的两个数，将大的数往右移。第一趟比较得出最大的数并放置数组最右端，
 * 第二趟比较得出第二大的数并放置在数组右端倒数第二位，如此往复，共N趟。
 * 
 * 最好的情况下交换次数为0，比较次数为N(N-1)/2
 * 最坏的情况下交换次数为N(N-1)/2，比较次数为N(N-1)/2
 * 平均交换次数约为 (N^2)/4 ，比较次数约为 (N^2)/2
 * 时间复杂度为：O(N^2)
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月8日 下午2:29:02
 */
public class BubbleSort implements Sortable{

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    exchange(array, j, j + 1);
                }
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        testCase(new BubbleSort(), 10000);
    }
    
}
