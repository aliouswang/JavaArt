package com.aliouswang.olympic.linklist;

import com.aliouswang.olympic.util.Log;

import java.util.List;

public class LinkListFactory {

    public static  <T> LinkListNode<T> generate(List<T> dataList) {
        LinkListNode<T> head = null;
        LinkListNode<T> cur = null;
        for (int i = 0; i < dataList.size(); i++) {
            LinkListNode<T> newNode = new LinkListNode<>(dataList.get(i));
            if (head == null) {
                head = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    public static <T> void printLinkList(LinkListNode<T> linkList) {
        LinkListNode<T> cur = linkList;
        while (cur != null) {
            System.out.print(cur.data + ",");
            cur = cur.next;
        }
        Log.d("");
    }

    public static <T> LinkListNode<T> reverse(LinkListNode<T> linkList) {
        LinkListNode<T> pre, cur, next;
        cur = linkList;
        pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
