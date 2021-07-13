package com.freedy.learn;

import java.util.*;

/**
 * @author Freedy
 * @date 2021/7/12 21:10
 */
public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(new Pattern().isMatch(scanner.nextLine(), scanner.nextLine()));
            System.out.println("---------------------------");
        }
        //"mississippi"
        //"mis*is*ip*."
    }

    @SuppressWarnings("AlibabaAvoidComplexCondition")
    public boolean isMatch(String s, String p) {
        String[] pattern = split(p);
        int cursor = 0;
        int length = s.length();
        for (int i = 0; i < pattern.length && cursor < length; i++) {
            String pat = pattern[i];
            if (pat.length() == 1) {
                if (".".equals(pat)) {
                    cursor++;
                } else if (s.charAt(cursor) == pat.charAt(0)) {
                    cursor++;
                } else return false;
            } else {
                for (char c = pat.charAt(0); cursor < length && (s.charAt(cursor) == c || c == '.'); cursor++) {
                    if (i < pattern.length - 1) {
                        char preRead = pattern[i + 1].charAt(0);
                        if (s.charAt(cursor) == preRead) {
                            int j = i + 2, k = cursor + 1;
                            for (; j < pattern.length && (pattern[j].charAt(0) == preRead || pattern[j].charAt(0) == '.'); j++) ;
                            for (; k < s.length() && s.charAt(k) == preRead; k++) ;
                            for (int l = i+1 ; l < j; l++) {
                                if (pattern[l].length()==2){
                                    cursor = k;
                                    i = j - 1;
                                    break;
                                }
                            }
                            if (j - i - 1 < k - cursor) {
                                cursor = k;
                                i = j - 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return cursor == length;
    }

    public String[] split(String p) {
        List<String> list = new LinkedList<>();
        char[] charArray = p.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i < charArray.length - 1 && charArray[i + 1] == '*') {
                list.add(charArray[i] + "*");
                i++;
            } else {
                list.add(charArray[i] + "");
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(list.get(i+1))){
                list.remove(i);
                i--;
            }
        }
        return list.stream().distinct().toArray(String[]::new);
    }


}
