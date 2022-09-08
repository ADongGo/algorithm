package com.adong.base.sort.solution;

import com.adong.base.sort.base.QuickSort;
import com.adong.base.sort.base.Sort;

import java.util.Arrays;

/**
 * @author adong
 * @Description 冒泡排序、插入排序、选择排序
 * @Date 2022-08-10 9:51 PM
 */
public class BaseSortDemo {

    public static void main(String[] args) {

        int[] array = new int[]{4,1,2,7,10,5};
        Sort sort = new QuickSort();
        sort.sort(array);
        for (int i: array) {
            System.out.println(i);
        }

        Arrays.sort(array);
    }
}
