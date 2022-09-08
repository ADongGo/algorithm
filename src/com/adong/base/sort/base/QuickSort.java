package com.adong.base.sort.base;

/**
 * @author adong
 * @Description 快速排序，先将数组进行分区 -> 左分区数据小于右边分区数据，然后递归分治
 * @Date 2022-08-23 5:08 PM
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {

        if(array == null || array.length < 2) return;
        dfs(array, 0, array.length - 1);
    }

    private void dfs(int[] array, int left, int right) {

        // 终止条件
        if (left >= right) return;

        // 找出分区点
        int partition = partition(array, left, right);
        dfs(array, left, partition - 1);
        dfs(array, partition + 1, right);
    }

    // 分区后的数据，左边 < 右边
    private int partition(int[] array, int left, int right) {

        int i = left;
        int pivot = array[right];
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }
        array[right] = array[i];
        array[i] = pivot;
        return i;
    }
}
