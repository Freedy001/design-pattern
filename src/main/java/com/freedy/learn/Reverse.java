package com.freedy.learn;

import java.util.*;

/**
 * @author Freedy
 * @date 2021/7/12 15:29
 */
public class Reverse {
    public static void main(String[] args) {
        System.out.println(new Reverse().longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < charArray.length-1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                int cursor = 0;
                int l = i, r = i + 1;
                //noinspection StatementWithEmptyBody
                for (; l >= 0 && r < charArray.length && charArray[l] == charArray[r];
                     l--, r++, cursor+=2) { }
                map.put(cursor, new int[]{l + 1, r});
            }
            if (i > 0 && charArray[i - 1] == charArray[i + 1]) {
                int cursor = 1;
                int l = i - 1, r = i + 1;
                //noinspection StatementWithEmptyBody
                for (; l >= 0 && r < charArray.length && charArray[l] == charArray[r];
                     l--, r++, cursor+=2) { }
                map.put(cursor, new int[]{l + 1, r});
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer integer : map.keySet()) {
            if (integer > max) max = integer;
        }
        if (max==Integer.MIN_VALUE) return s.substring(0,1);
        int[] ints = map.get(max);
        return s.substring(ints[0], ints[1]);
    }
}
