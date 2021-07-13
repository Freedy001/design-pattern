package com.freedy.learn;

import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freedy
 * @date 2021/7/11 20:18
 */
public class 两数相加 {
    public static void main(String[] args) {
        两数相加 test = new 两数相加();
        ListNode node1 = test.new ListNode(9);
        ListNode node4 = test.new ListNode(1, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9, test.new ListNode(9))))))))));
//        node4.print();
        test.addTwoNumbers(node1, node4).print();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0), head = node, pre = null;
        while (l1 != null || l2 != null) {
            int sum = node.val;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (sum > 9) {
                node.val = sum % 10; //sum个位数
                node.next = new ListNode(1);
            } else {
                node.val = sum;
                node.next = new ListNode(0);
            }
            pre = node;
            node = node.next;
        }
        if (node.val==0&&pre!=null)
            pre.next=null;
        return head;
    }


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        void print() {
            ListNode node = this;
            while (node.next != null) {
                System.out.print(node.val + ",");
                node = node.next;
            }
            System.out.println(node.val);
        }
    }
}
