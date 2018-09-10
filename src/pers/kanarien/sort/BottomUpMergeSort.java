package pers.kanarien.sort;
import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;

/**
 * 自底向上归并排序(BottomUpMergeSort)：
 * 同样使用归并的思想，即将两个有序的数组合并成一个更大的有序数组。
 * 不同的是，自顶向下使用的是递归，把大的数组分成小的数组进行归并，
 * 而自底向上使用的是迭代，把小的数组组合成大的数组进行归并。
 * 
 * 效率方面同自顶向下归并排序，但一般情况下，迭代优于递归。
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月9日 下午1:09:24
 */
public class BottomUpMergeSort implements Sortable{

    private static int[] aux;
    
    @Override
    public void sort(int[] array) {
        int n = array.length;
        aux = new int[n];
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(array, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    /**
     * 归并
     * @param array 排序数组
     * @param lo 最低位索引
     * @param mid 中间位索引
     * @param hi 最高位索引
     */
    private static void merge(int[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }
    
    public static void main(String[] args) {
        testCase(new BottomUpMergeSort(), 100);
    }
}
