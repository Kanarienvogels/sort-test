package pers.kanarien.sort;

import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 希尔排序(ShellSort)：
 * 基于插入排序改进的排序算法，思想是使数组中任意间隔为h的数都是有序的。
 * 交换不相邻的数以对数组进行局部排序，一个h有序数组就是h个互相独立的有序数组编织在一起组成一个数组，
 * 当h减少至1，相当于执行了一次插入排序，此时数组有序，
 * 增量h的数列称为增量序列。
 * 
 * 希尔排序的时间复杂度与增量序列有关。
 * 当使用如下增量序列时，希尔排序的时间复杂度为O(N^(3/2))
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月8日 下午9:22:56
 */
public class ShellSort implements Sortable{

    @Override
    public void sort(int[] array) {
        int n = array.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1; // 递增序列
        }
        while (h >= 1) { // 循环体里面就是插入排序
            /*int min = 0;
            for (int i = h; i < n; i += h) {
                if (array[min] > array[i]) {
                    min = i;
                }
            }
            if (min != 0) {
                exchange(array, 0, min);
            } 
            for (int i = 2 * h; i < n; i += h) {
                int j = i;
                int temp = array[i];
                if (array[i] < array[i - h]) {
                    do {
                        j -= h;
                        array[j + h] = array[j];
                    } while (temp < array[j - h]);
                }
                array[j] = temp;
            }*/
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    exchange(array, j, j - h);
                }
            }
            h /= 3;
        }
    }
    
    public static void main(String[] args) {
        testCase(new ShellSort(), 100);
    }

}
