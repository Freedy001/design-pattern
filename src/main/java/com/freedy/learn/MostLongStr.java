package com.freedy.learn;

import java.util.*;

/**
 * @author Freedy
 * @date 2021/7/12 9:21
 */
public class MostLongStr {
    public static void main(String[] args) {
        System.out.println(new MostLongStr().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        List<Integer> lengthList = new ArrayList<>();
        char[] charArray = s.toCharArray();
        int preLeftPosition = -1;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.containsKey(c)) {
                if (map.get(c) <= preLeftPosition) {
                    lengthList.add(i - preLeftPosition);
                } else {
                    lengthList.add(i - preLeftPosition - 1);
                    preLeftPosition = map.get(c);
                }
            }
            map.put(c, i);
        }
        lengthList.add(charArray.length - 1 - preLeftPosition);
        int result;
        return (result = lengthList.stream().max(Comparator.comparingInt(a -> a)).orElse(0)) == 0 ? s.length() : result;
    }
}
