package com.chen.linkedlist.Double;

public class DoubleLinkedList {
    private DoubleHeroNode head = new DoubleHeroNode(0, "", "");

    //遍历链表（打印）
    public void showList() {
        if (isEmpty()) {
            return;
        }
        DoubleHeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //将节点添加到双向线链表中
    //找到当前链表的最后节点
    //将这个节点的next指向新的节点
    public void add(DoubleHeroNode doubleHeroNode) {
        //Head节点不动， 因此需要一个辅助节点temp
        DoubleHeroNode temp = head;
        //遍历链表，找到最后一个节点
        while (true) {
            //找到最后一个节点，退出循环
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后一个节点，就将temp向后移动
            temp = temp.next;
        }
        //当退出while循环后，说明找到了最后一个节点，将该节点的next指向新的节点
        temp.next = doubleHeroNode;
        doubleHeroNode.pre = temp;
    }

    //在添加英雄时，根据英雄排名将英雄插入刀指定位置
    // 如果该排名有人，则提示添加失败，并给出提示
    public void addByOrder(DoubleHeroNode doubleHeroNode) {
        DoubleHeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > doubleHeroNode.no) {
                break;
            } else if (temp.next.no == doubleHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d 已经存在了，不能插入\n", doubleHeroNode.no);
        } else {
            doubleHeroNode.next = temp.next;
            doubleHeroNode.pre = temp;
            if (temp.next != null) {
                temp.next.pre = doubleHeroNode;
            }
            temp.next = doubleHeroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能修改
    //说明
    //1. 根据newHeroNode的no来修改即可
    public void update(DoubleHeroNode newDoubleHeroNode) {
        //判断是否为空
        if (isEmpty()) {
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        DoubleHeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //已经完全遍历链表
            }
            if (temp.no == newDoubleHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newDoubleHeroNode.name;
            temp.nickName = newDoubleHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号%d 的节点， 不能修改\n", newDoubleHeroNode.no);
        }
    }

    //删除节点
    //思路
    //对于双向链表，直接找到要删除的节点进行自我删除
    public void delete(int no) {

        //判断是否为空
        if (isEmpty()) {
            System.out.println("链表为空或、，无法删除");
        }
        DoubleHeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的节点%d不存在\n", no);
        }
    }

    //判断链表为空
    public boolean isEmpty() {
        if (head.next == null) {
            System.out.println("链表为空");
            return true;
        }
        return false;
    }
}
