package com.adong.base.solution;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author beiting
 * @Description Solution15
 * @Date 2022-09-16 5:06 PM
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *  
 * 提示：
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 输入
 * [-1,0,1,2,-1,-4]
 * 输出
 * [[-1,0,1],[-1,2,-1],[0,1,-1]]
 * 预期结果
 * [[-1,-1,2],[-1,0,1]]
 */
public class Solution15 {


    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList();
        Map<Character, List<String>> map = new HashMap();
        map.put('2', new ArrayList(Arrays.asList("a","b","c")));
        map.put('3', new ArrayList(Arrays.asList("d","e","f")));
        map.put('4', new ArrayList(Arrays.asList("g","h","i")));
        map.put('5', new ArrayList(Arrays.asList("j","k","l")));
        map.put('6', new ArrayList(Arrays.asList("m","n","o")));
        map.put('7', new ArrayList(Arrays.asList("p","q","r","s")));
        map.put('8', new ArrayList(Arrays.asList("t","u","v")));
        map.put('9', new ArrayList(Arrays.asList("w","x","y","z")));
        char[] chars = digits.toCharArray();
        List<String> list = new ArrayList();
        for(int i = 0; i < chars.length; i++) {
            list.addAll(map.get(chars[i]));
        }
        List<String> result = new ArrayList();
        for(int j = 0; j < list.size() - 2; j++) {
            for(int l = j + 1; l < list.size() - 1; l++) {
                result.add(list.get(j) + list.get(l));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Solution15.letterCombinations("23");
    }
}
