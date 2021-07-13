package com.freedy.learn;

import java.util.*;

/**
 * @author Freedy
 * @date 2021/6/26 23:11
 */
public class StringMatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int turn = scanner.nextInt();
        String[] strArr = new String[turn];
        for (int i = 0; i < turn; i++) {
            strArr[i] = scanner.next();
        }
        for (String s : strArr) {
            List<Character> charArray = new LinkedList<>();
            for (char c : s.toCharArray()) {
                charArray.add(c);
            }
            try {
                for (int i = 0; i < charArray.size(); i++) {
                    if (charArray.get(i).equals(charArray.get(i + 1))) {
                        while (true) {
                            if (charArray.get(i + 1).equals(charArray.get(i + 2))) { // condition 1
                                charArray.remove(i + 2);
                            } else { // condition 2
                                if (charArray.get(i + 2).equals(charArray.get(i + 3))) {
                                    charArray.remove(i + 3);
                                }
                                break;
                            }
                        }
                    }
                }
            } catch (IndexOutOfBoundsException ignore) {
            }
            char[] str=new char[charArray.size()];
            for (int i = 0; i < charArray.size(); i++) {
                str[i]=charArray.get(i);
            }
            System.out.println(new String(str));
        }
    }
}
