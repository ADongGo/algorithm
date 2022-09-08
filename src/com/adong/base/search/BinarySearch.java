package com.adong.base.search;

/**
 * @author adong
 * @Description BinarySearch
 * @Date 2022-04-25 1:18 PM
 */
public class BinarySearch {

    public int binarySearchNoRecursive(int[] array, int k) {

        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = (right - left) >> 2 + left;
            if (k == array[mid]) {
                return mid;
            } else if (k > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] array, int k) {

        if (array == null || array.length == 0) return -1;
        return dfs(array, 0, array.length - 1, k);
    }

    private int dfs(int[] array,int left, int right, int k) {
        // 终止条件
        if (left > right) {
            return -1;
        }
        int mid = ((right - left) >> 1) + left;
        if (k == array[mid]) {
            return mid;
        } else if (k > array[mid]) {
            return dfs(array, mid + 1, right, k);
        } else {
            return dfs(array, left, mid + 1, k);
        }
    }

    /**
     * 二分查找，找到第一个符合的数
     *
     */
    public int binarySearchFirst(int[] array, int k) {

        if (array == null || array.length == 0) return -1;
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (k > array[mid]) {
                left = mid + 1;
            } else if (k < array[mid]) {
                right = mid - 1;
            } else if (mid == 0 || array[mid - 1] != k) {
                return mid;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
