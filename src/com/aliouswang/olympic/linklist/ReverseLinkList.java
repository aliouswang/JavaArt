package com.aliouswang.olympic.linklist;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkList {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add(i);
        }
        LinkListNode<Integer> linkList = LinkListFactory.generate(numberList);
        LinkListFactory.printLinkList(linkList);

        LinkListNode<Integer> reverseList = LinkListFactory.reverse(linkList);
        LinkListFactory.printLinkList(reverseList);
    }

}
