package pers.kanarien.sort.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pers.kanarien.sort.BottomUpMergeSort;
import pers.kanarien.sort.BubbleSort;
import pers.kanarien.sort.HeapSort;
import pers.kanarien.sort.InsertionSort;
import pers.kanarien.sort.InsertionSortEX;
import pers.kanarien.sort.QuickSort;
import pers.kanarien.sort.SelectionSort;
import pers.kanarien.sort.ShellSort;
import pers.kanarien.sort.TopDownMergeSort;
import pers.kanarien.sort.common.Sortable;

import static pers.kanarien.sort.common.SortUtils.*;

public class SortSpeedTest {

    private static void testSpeed(Sortable sortable, int times, int size) {
        Set<int[]> arraySet = new HashSet<int[]>();
        for (int i = 0; i < times; i++) {
            int[] array = generateRandomArray(size);
            arraySet.add(array);
        }
        long begin = System.currentTimeMillis();
        arraySet.stream().forEach(array -> sortable.sort(array));
        long end = System.currentTimeMillis();
        System.out.print(sortable.getClass().getTypeName()
                .substring(sortable.getClass().getTypeName().lastIndexOf(".") + 1) 
                + " 耗费 " + (end - begin) + " ms ");
        List<int[]> checkResult = arraySet.stream()
            .filter(array -> !isSorted(array))
            .collect(Collectors.toList());
        if (checkResult.isEmpty()) {
            System.out.println(" 经检查，测试数组全部有序");
        } else {
            System.out.println(" 经检查，测试数组中含有排序不正确的情况，排序错误数组个数为 " + checkResult.size());
        }
    }
    
    public static void main(String[] args) {
        testSpeed(new BubbleSort(), 100, 10000);
        testSpeed(new SelectionSort(), 100, 10000);
        testSpeed(new InsertionSort(), 100, 10000);
        testSpeed(new InsertionSortEX(), 100, 10000);
        testSpeed(new ShellSort(), 100, 10000);
        testSpeed(new TopDownMergeSort(), 100, 10000);
        testSpeed(new BottomUpMergeSort(), 100, 10000);
        testSpeed(new QuickSort(), 100, 10000);
        testSpeed(new HeapSort(), 100, 10000);
    }
}
