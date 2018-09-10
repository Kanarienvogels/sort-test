package pers.kanarien.sort;
import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 自顶向下归并排序(TopDownMergeSort):
 * 归并指的是将两个有序的数组合并成一个更大的有序数组。
 * 结合递归的思想，数组自顶向下对半排序，
 * 即将大的数组分成两半分别排序，然后把其中一半的数组再分成两半，直到数组长度为1，最后将结果归并。
 * 
 * 
 * 需要比较次数为(1/2)NlogN到NlogN，访问数组次数最多为6NlogN (2N复制，2N移回元素，2N比较)
 * 时间复杂度为O(NlogN)
 * 空间复杂度为O(N)
 * 
 * 优化手段：
 * 1. 数组大小较小时使用插入排序
 * 2. 不将元素复制到辅助数组，而是交替使用排序数组与辅助数组
 * 3. 在归并前测试下数组是否已经有序，即是否满足array[mid] <= array[mid + 1]
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月9日 上午11:46:46
 */
public class TopDownMergeSort implements Sortable{

    private static int[] aux;
    
    @Override
    public void sort(int[] array) {
        aux = new int[array.length];
        sort(array, 0, array.length - 1);
    }
    
    /**
     * 递归排序
     * @param array 排序数组
     * @param lo 最低位索引
     * @param hi 最高位索引
     */
    private static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
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
        testCase(new TopDownMergeSort(), 10000);
    }

}
