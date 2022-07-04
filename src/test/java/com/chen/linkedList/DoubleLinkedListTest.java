package com.chen.linkedList;

import com.chen.linkedlist.Double.DoubleHeroNode;
import com.chen.linkedlist.Double.DoubleLinkedList;
import org.junit.Test;

public class DoubleLinkedListTest {
    DoubleHeroNode doubleHeroNode1 = new DoubleHeroNode(1, "宋江", "及时雨");
    DoubleHeroNode doubleHeroNode2 = new DoubleHeroNode(2, "卢俊义", "玉麒麟");
    DoubleHeroNode doubleHeroNode3 = new DoubleHeroNode(3, "吴用", "智多星");
    DoubleHeroNode doubleHeroNode4 = new DoubleHeroNode(4, "林冲", "豹子头");

    //创建单链表
    DoubleLinkedList doubleLinkedList = new DoubleLinkedList();



    //测试添加方法
    @Test
    public void testSingleLinkedListAdd() {
        doubleLinkedList.add(doubleHeroNode1);
        doubleLinkedList.add(doubleHeroNode2);
        doubleLinkedList.add(doubleHeroNode3);
        doubleLinkedList.add(doubleHeroNode4);

        //显示链表
        doubleLinkedList.showList();
    }

    //测试有序添加
    @Test
    public void testDoubleLinkedListAddByOrder() {
        doubleLinkedList.addByOrder(doubleHeroNode1);
        doubleLinkedList.addByOrder(doubleHeroNode4);
        doubleLinkedList.addByOrder(doubleHeroNode3);
        doubleLinkedList.addByOrder(doubleHeroNode2);
        doubleLinkedList.addByOrder(doubleHeroNode3);

        //显示链表
        doubleLinkedList.showList();
    }

    //测试修改
    @Test
    public void testDoubleLinkedListUpdate() {
        doubleLinkedList.add(doubleHeroNode1);
        doubleLinkedList.add(doubleHeroNode2);
        doubleLinkedList.add(doubleHeroNode3);
        doubleLinkedList.add(doubleHeroNode4);

        doubleLinkedList.showList();

        DoubleHeroNode newDoubleHeroNode = new DoubleHeroNode(4,"公孙胜", "入云龙");
        doubleLinkedList.update(newDoubleHeroNode);

        System.out.println("修改后的链表输出：");

        //显示链表
        doubleLinkedList.showList();
    }

    //测试删除
    @Test
    public void testDoubleLinkedListDelete() {
        doubleLinkedList.add(doubleHeroNode1);
        doubleLinkedList.add(doubleHeroNode2);
        doubleLinkedList.add(doubleHeroNode3);
        doubleLinkedList.add(doubleHeroNode4);

        doubleLinkedList.showList();

        doubleLinkedList.delete(1);
        doubleLinkedList.showList();
        doubleLinkedList.delete(4);
        doubleLinkedList.showList();
        doubleLinkedList.delete(3);
        doubleLinkedList.delete(4);

        doubleLinkedList.showList();
        doubleLinkedList.delete(2);

        doubleLinkedList.showList();
    }
}
