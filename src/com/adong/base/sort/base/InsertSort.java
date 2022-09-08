package com.adong.base.sort.base;

/**
 * @author adong
 * 插入排序，整体数组分为「排序完成」和「未排序」两部分，
 * 遍历「未排序」部分，插入到合适的位置
 *
 * @Date 2022-08-24 12:49 PM
 */
public class InsertSort implements Sort {

    /**
     * 移动元素的时间复杂度是O(1),先取出临时元素
     * @param array
     */
    @Override
    public void sort(int[] array) {

        int size = array.length;
        if(size <= 1) return;
        for(int i = 1; i < size; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 如果大于移动位置
                if (array[j] > value) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }
}
