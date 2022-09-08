package com.adong.base.sort.base;

/**
 * @author adong
 * @Description 冒泡排序，遍历和交换
 * @Date 2022-08-24 12:48 PM
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] array) {

        int size = array.length;
        if (array.length <= 1) return;
        for (int i = 1; i < size; i++) {
            boolean flag = false;
            for (int j = 0; j < size - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true; // 有数据交换
                }
            }
            if (!flag) return;
        }
    }
}
