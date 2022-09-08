package com.adong.base.question;

/**
 * @author adong
 * @Description Test2
 * @Date 2022-08-26 11:15 PM
 */
public class Test2 {

    public static void main(String[] args) {

        int[] nums = new int[]{4,5,6,7,0,1,2};
    }

    public static int search(int[] nums, int target) {
        int l2 = 0;
        // 寻找旋转点
        for(int i = 0; i <= nums.length; i++) {
            if(nums[i] > nums[i + 1]) {
                l2 = i + 1;
                break;
            }
        }
        int i1 = searchInternally(nums, 0, l2 - 1, target);
        if(i1 != -1) return i1;
        return searchInternally(nums, l2, nums.length - 1, target);
    }

    private static int searchInternally(int[] nums, int left, int right, int target){
        while(left <= right) {
            int mid = ((right - left) >> 1) + left;
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
