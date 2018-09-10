package pers.kanarien.sort.common;

import java.util.Random;

public class SortUtils {
    
    private final static Integer DEFAULT_ARRAY_SIZE = 10;

    public static void exchange(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    
    public static boolean isSorted(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }
        return array;
    }
    
    public static void print(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空");
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
    
    public static void testCase(Sortable sortable) {
        testCase(sortable, DEFAULT_ARRAY_SIZE);
    }
    
    public static void testCase(Sortable sortable, int size) {
        int[] array = generateRandomArray(size);
        System.out.println("数组长度为：" + size);
        System.out.print("排序前：");
        print(array);
        sortable.sort(array);
        System.out.print("排序后：");
        print(array);
        if (isSorted(array)) {
            System.out.println("是否有序：是");
        } else {
            System.out.println("是否有序：无");
        }
    }
}
