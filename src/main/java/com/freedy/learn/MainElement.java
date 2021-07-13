package com.freedy.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Freedy
 * @date 2021/7/9 18:29
 */
public class MainElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.merge(num, 1,(a,b)->{
                System.out.println(a+"  "+b);
                return a+b;
            });
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
