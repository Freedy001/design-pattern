package com.freedy.tree;

/**
 * @author Freedy
 * @date 2021/6/15 22:00
 */
public class Test1 {
    public static void main(String[] args) {
        RedBlackTree<Integer, Integer> tree = new RedBlackTree<>();
        tree.singlePut(8);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(9);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(1);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(0);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(3);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(5);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(6);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(4);
        System.out.println(tree);
        System.out.println("====================");
        tree.singlePut(2);
        System.out.println(tree);
        System.out.println(tree.check());
    }
}
