package com.adong.base.dp;

/**
 * @author beiting
 * @Description Solution322
 * @Date 2022-10-01 11:36 PM
 */
public class Solution322 {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 40));
    }

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        for(int c: coins) {
            if(amount == c) return 1;
        }
        int min = Integer.MAX_VALUE;
        for(int c: coins) {
            int result = coinChange(coins, amount - c);
            if(result != -1) {
                min = Math.min(result, min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }
}
