package com.adong.base.dp;

/**
 * @author beiting
 * @Description Solution494
 * @Date 2022-09-29 2:51 PM
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * 示例 2：
 * 输入：nums = [1], target = 1
 * 输出：1
 *
 */
public class Solution494 {

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    // 动态规划，将问题转化为 0-1 背包问题，dp[i][j]
    public static int findTargetSumWays(int[] nums, int target) {
        // 先计算数组总和, 取动态规划范围,i: [0, nums.length - 1], j: [-sum, sum]
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        if (target > sum || target < - sum) return 0;
        target += sum;
        int jLen = (sum << 1) + 1;
        int[][] dp = new int[nums.length][jLen];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for(int i = 1; i < nums.length; i++) {
            for (int j = nums[i]; j < jLen; j++) {
                if(dp[i - 1][j] > 0) {
                    if (j >= nums[i]) { // -
                        dp[i][j - nums[i]] += dp[i - 1][j];
                    }
                    if (j < jLen - nums[i]) { // +
                        dp[i][j + nums[i]] += dp[i - 1][j];
                    }
                }
            }
        }
        return dp[nums.length - 1][target];
    }

//    // 优化为一纬数组
//    public static int findTargetSumWays2(int[] nums, int target) {
//        // 先计算数组总和, 取动态规划范围,i: [0, nums.length - 1], j: [-sum, sum]
//        int sum = 0;
//        for (int num: nums) {
//            sum += num;
//        }
//        if (target > sum || target < - sum) return 0;
//        target += sum;
//        int jLen = (sum << 1) + 1;
//        int[][] dp = new int[nums.length][jLen];
//        if (nums[0] == 0) {
//            dp[0][sum] = 2;
//        } else {
//            dp[0][sum + nums[0]] = 1;
//            dp[0][sum - nums[0]] = 1;
//        }
//        for(int i = 1; i < nums.length; i++) {
//            for (int j = nums[i]; j < jLen; j++) {
//                if(dp[i - 1][j] > 0) {
//                    if (j >= nums[i]) { // -
//                        dp[i][j - nums[i]] += dp[i - 1][j];
//                    }
//                    if (j < jLen - nums[i]) { // +
//                        dp[i][j + nums[i]] += dp[i - 1][j];
//                    }
//                }
//            }
//        }
//        return dp[nums.length - 1][target];
//    }
}
