package com.freedy.learn;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Freedy
 * @date 2021/7/11 20:02
 */
public class 两数之和 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}
