package pers.kanarien.sort;
import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 快速排序：
 * 与归并排序互补，利用递归思想，当两个子数组都有序时，整个数组就有序了。
 * 
 * 取最左端的元素作为切分元素，从数组左端开始找到一个比它大的数，然后从数组右端找到一个比它小的数，
 * 二者交换，然后又从上次左端找到的位置开始继续寻找下一个比切分元素小的数，以此往复，直到左右指针相遇，
 * 此时将切分元素和左子数组最右侧元素交换，整个数组就有序了。
 * 
 * 优点:原地切分不需要额外的空间；在内循环中不需要移动数据(而归并排序、希尔排序都要在内循环移动数据)。
 * 缺点：算法本身比较脆弱；排序前需要预先打乱数组，为了防止出现最坏的情况(达到平方级)；而且写起来很容易出错，
 * 比如数组越界、死循环；对重复值也比较敏感。所以实际上广为应用的快排有许多的改进，
 * 比如三取样切分来选取更好的切分元素、熵最优排序以应对多重复值。
 * 
 * 时间复杂度O(NlogN)
 * 空间复杂度O(1)，使用原地排序
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月9日 下午3:55:40
 */
public class QuickSort implements Sortable{

    @Override
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int j = partition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }
    
    private static int partition(int[] array, int lo, int hi) {
        int i = lo, j = hi + 1; // i, j是左右扫描指针，array[lo]是切分元素
        while (true) {
            while (array[lo] > array[++i]) {
                if (i == hi) {
                    break;
                }
            }
            while (array[lo] < array[--j]);
            if (i >= j) {
                break;
            }
            exchange(array, i, j);
        }
        exchange(array, j, lo);
        return j;
    }
    
    public static void main(String[] args) {
        testCase(new QuickSort(), 10000);
    }
}
