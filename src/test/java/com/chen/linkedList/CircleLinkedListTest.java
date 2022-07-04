package com.chen.linkedList;

import com.chen.linkedlist.circle.CircleSingleLinkedList;
import org.junit.Test;

public class CircleLinkedListTest {

    @Test
    public void testCreateAndTraversalCircleLinkedList() {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();

        //测试约瑟夫问题
        circleSingleLinkedList.Josephus(2,2);
    }
}
