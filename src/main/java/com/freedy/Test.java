package com.freedy;


import lombok.Data;
import org.w3c.dom.Node;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/**
 * @author Freedy
 * @date 2021/6/10 23:12
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        Node head = new Node(0);
        Node tail=head;
        for (int i = 1; i < 10; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        System.out.println(head);
        Node pre=head,current=pre.next,next=current.next, newHead;
        pre.next=null;
        for (;next!=null;pre=current,current=next,next=next.next)
            current.next=pre;
        current.next=pre;
        newHead=current;
        System.out.println(newHead);
    }

    @Data
    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
