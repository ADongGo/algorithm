package com.adong.base.array;

/**
 * @author beiting
 * @Description Solution283
 * @Date 2022-10-14 11:14 AM
 */
public class Solution283 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZero(nums);
        for(int num: nums) {
            System.out.println(num);
        }
    }

    public static void moveZero(int[] nums) {

        int privot = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[privot];
                nums[privot] = temp;
                privot++;
            }
        }
    }

//    public static void moveZero(int[] nums) {
//
//        int l = 0, r = nums.length - 1;
//        while(l < r) {
//            if(nums[r] == 0) {
//                r--;
//                continue;
//            }
//            if(nums[l] == 0) {
//                int temp = nums[l];
//                nums[l] = nums[r];
//                nums[r] = temp;
//                r--;
//            }
//            l++;
//        }
//    }
}
