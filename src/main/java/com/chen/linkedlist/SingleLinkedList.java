package com.chen.linkedlist;

// 定义一个SingleLinkedList 管理英雄
public class SingleLinkedList {
    //初始化一个头节点，不存放任何具体数据
    private final HeroNode head = new HeroNode(0, "", "");

    //将节点添加刀单线链表中
    //找到当前链表的最后节点
    //将这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //Head节点不动， 因此需要一个辅助节点temp
        HeroNode temp = head;
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
        temp.next = heroNode;
    }

    //在添加英雄时，根据英雄排名将英雄插入刀指定位置
    // 如果该排名有人，则提示添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄编号%d 已经存在了，不能插入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来修改，即no编号不能修改
    //说明
    //1. 根据newHeroNode的no来修改即可
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (isEmpty()) {
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break; //已经完全遍历链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号%d 的节点， 不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    //思路
    //使用辅助节点找到待删除的节点的前一个节点，即temp.next.no与要删除的节点的no比较
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
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

    //遍历链表（打印）
    public void showList() {
        if (isEmpty()) {
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //获取刀单链表的节点个数（如果为带头结点链表的话，需不统计头节点）
    public int getLength() {
        if (isEmpty()) {
            return 0;
        }
        int length = 0;
        //没有统计头节点
        HeroNode current = head.next;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    //查找单链表中的倒数第K个节点
    /*
     * 思路：
     *   1 得到长度和需要查找的节点在倒数第index个
     *   2 从链表中遍历length-index即可得到该节点
     *   3 找到则返回该节点，否则返回null
     * */
    public HeroNode findLastIndexNode(int index) {
        if (isEmpty()) {
            return null;
        }
        int size = getLength();
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode current = head.next;
        for (int i = 0; i < size - index; i++) {
            current = current.next;
        }
        return current;
    }
}
