package pers.kanarien.sort;

import static pers.kanarien.sort.common.SortUtils.*;

import pers.kanarien.sort.common.Sortable;
/**
 * 堆排序：
 * 利用数据结构 堆 的特性进行排序。
 * 当堆为大顶堆时，根结点是所有结点中最大的，把根结点和最末端的结点交换（堆结构会被破坏），
 * 然后对新的根结点进行筛选，且筛选前堆大小减1，即忽略最末端的旧根结点，
 * 筛选后成为新的堆，如此循环，相当于逐一找出最大、次大、次次大的结点并按顺序放在数组末尾。
 * 
 * 时间复杂度O(NlogN)
 * 空间复杂度O(1)，属于就地排序
 * 
 * @author Kanarien 
 * @version 1.0
 * @date 2018年9月10日 下午8:36:58
 */
public class HeapSort implements Sortable{

    @Override
    public void sort(int[] array) {
        Heap heap = makeHeap(array);
        for (int i = array.length; i > 0; i--) {
            removeFirst(heap);
        }
    }

    /**
     * 建堆
     * @param array
     * @return
     */
    private Heap makeHeap(int[] array) {
        Heap heap = new Heap(array.length, array);
        for (int i = array.length / 2 ; i >= 0; i--) {
            shiftDown(heap, i);
        }
        return heap;
    }
    
    /**
     * 筛选：
     * 使以pos为根的子树调整为子堆，前提是pos结点左右子树均为子堆。
     * @param heap
     * @param pos
     */
    private void shiftDown(Heap heap, int pos) {
        int lc, rc;
        while (pos < heap.getLength() / 2) {
            lc = pos * 2 + 1;  //左孩子
            rc = pos * 2 + 2;  //右孩子
            if (rc < heap.getLength() && heap.greatPrior(heap.getArray()[rc], heap.getArray()[lc])) {
                lc = rc;
            }
            if (heap.greatPrior(heap.getArray()[pos], heap.getArray()[lc])) {
                return;
            }
            exchange(heap.getArray(), pos, lc);
            pos = lc;
        }
    }
    
    /**
     * 删除堆顶结点：
     * 1. 取出堆顶结点；
     * 2. 将堆顶结点与堆尾结点交换位置，并将对长度减1；
     * 3. 对堆顶结点进行筛选。
     */
    private void removeFirst(Heap heap) {
        if (heap.getArray() == null || heap.getLength() <= 0) {
            return;
        }
        exchange(heap.getArray(), 0, heap.getLength() - 1);
        heap.setLength(heap.getLength() - 1);
        if (heap.getLength() > 1) {
            shiftDown(heap, 0);
        }
    }
    

    private class Heap {
        //堆长度
        private int length;
        //堆容器
        private int[] array;
        
        public Heap(int length, int[] array) {
            this.length = length;
            this.array = array;
        }
        
        public int getLength() {
            return length;
        }
        public void setLength(int length) {
            this.length = length;
        }
        public int[] getArray() {
            return array;
        }
        @SuppressWarnings("unused")
        public void setArray(int[] array) {
            this.array = array;
        }
        
        public boolean greatPrior(int x, int y) {
            return x >= y;
        }
        
        @SuppressWarnings("unused")
        public boolean lessPrior(int x, int y) {
            return x <= y;
        }
    }
    
    public static void main(String[] args) {
        testCase(new HeapSort(), 100);
    }
}
