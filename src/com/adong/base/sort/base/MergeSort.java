package com.adong.base.sort.base;

/**
 * @author adong
 * @Description 归并排序，整体思路：分治 + 合并
 * 将数据进行拆分，直到拆分不了，然后将拆分的数组按照顺序合并
 * @Date 2022-08-23 10:59 AM
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] array) {
        if (array == null || array.length < 2) return;
        int[] temp = new int[array.length];
        mergeSortDC(array, 0, array.length - 1, temp);
    }

    private void mergeSortDC(int[] array, int l, int r, int[] temp) {
        // 终止条件
        if (l >= r) return;
        int m = (l + r) / 2;
        // 分治
        mergeSortDC(array, l, m, temp);
        mergeSortDC(array, m + 1, r, temp);
        merge(array, l, m, r, temp);
    }

    private void merge(int[] array, int left, int mid, int right, int[] temp) {

        int i = left; // 左指针
        int j = mid + 1; // 右指针
        int t = 0; // 临时数组指针
        while(i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        while(i <= mid) {
            temp[t++] = array[i++];
        }
        while(j <= right) {
            temp[t++] = array[j++];
        }
        // 拷贝进array
        t = 0;
        for(int f = left; f <= right; f++) {
            array[f] = temp[t++];
        }
    }
}
