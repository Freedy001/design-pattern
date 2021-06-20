package com.freedy.tree;


import java.io.IOException;
import java.util.*;

/**
 * @author Freedy
 * @date 2021/6/9 21:23
 */
public class Test {
    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        for (int j = 0; j < 10; j++) {
            tree.singlePut(j);
        }
        System.out.println(tree);
        System.out.println("==============");
        for (int j = 0; j < 10; j++) {
            tree.remove(j);
        }
        System.out.println(tree);
    }

}
