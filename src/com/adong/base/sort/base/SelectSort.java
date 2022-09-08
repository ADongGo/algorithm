package com.adong.base.sort.base;

/**
 * @author adong
 * 选择排序，整体数组分为「排序完成」和「未排序」两部分，
 * 选择最小的数据索引和排序好数据的后一个数据进行交换
 *
 * @Date 2022-08-24 12:55 PM
 */
public class SelectSort implements Sort {

    @Override
    public void sort(int[] array) {

        int size = array.length;
        if (size <= 1) return;

        for(int i = 0; i < size; i++) {
            int minIndex = i;
            for(int j = i + 1; j < size; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
