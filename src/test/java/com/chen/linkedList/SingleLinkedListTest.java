package com.chen.linkedList;

import com.chen.linkedlist.HeroNode;
import com.chen.linkedlist.SingleLinkedList;
import org.junit.Test;

import java.util.Scanner;

public class SingleLinkedListTest {
    //创建节点
    HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
    HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
    HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
    HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");

    //创建单链表
    SingleLinkedList singleLinkedList = new SingleLinkedList();

    //测试添加方法
    @Test
    public void testSingleLinkedListAdd() {
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode4);

        //显示链表
        singleLinkedList.showList();
    }

    //测试有序添加
    @Test
    public void testSingleLinkedListAddByOrder() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);

        //显示链表
        singleLinkedList.showList();
    }

    //测试修改
    @Test
    public void testSingleLinkedListUpdate() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.showList();
        HeroNode newHeroNode = new HeroNode(2,"小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表输出：");

        //显示链表
        singleLinkedList.showList();
    }

    //测试修改
    @Test
    public void testSingleLinkedListDelete() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.showList();

        singleLinkedList.delete(1);
        singleLinkedList.showList();
        singleLinkedList.delete(4);
        singleLinkedList.showList();
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);

        singleLinkedList.showList();
        singleLinkedList.delete(2);

        singleLinkedList.showList();
    }

    //测试返回有效长度
    @Test
    public void testSingleLinkedListGetLength() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);


        //显示链表
        System.out.println("有效的节点个数为：" + singleLinkedList.getLength());
    }

    //测试获取倒数第K个节点
    @Test
    public void testSingleLinkedListGetFindLastIndexNode() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        singleLinkedList.showList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询要查询倒数第几个节点：");
        int k = scanner.nextInt();
        //显示链表
        System.out.printf("倒数第%d个节点为为：" + singleLinkedList.findLastIndexNode(k), k);
    }

    //测试反转链表
    @Test
    public void testSingleLinkedListReverseSingleLinkedList() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        System.out.println("原链表为：");
        singleLinkedList.showList();

        System.out.println("反转后的链表为：");
        singleLinkedList.reverseLinkedList().showList();
    }

    //测试使用栈进行逆序打印
    @Test
    public void testSingleLinkedListReversePrint() {
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode2);

        System.out.println("原链表为：");
        singleLinkedList.showList();

        System.out.println("逆序输出链表：");

        singleLinkedList.reversePrint();
    }

}
