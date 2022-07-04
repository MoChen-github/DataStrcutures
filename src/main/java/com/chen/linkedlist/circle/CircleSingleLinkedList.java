package com.chen.linkedlist.circle;

public class CircleSingleLinkedList {
    private Boy first = new Boy(-1);
    public void addBoy(int index) {
        if (index < 1) {
            System.out.println("index的值不正确");
            return;
        }
        Boy currentBoy = null;
        //使用for循环创建环形链表
        for (int i = 0; i < index; i++) {
            //根据编号创建节点
            Boy boy = new Boy(i+1);
            //如果是第一个小孩
            if (i == 0) {
                first = boy;
                first.setNext(first);
                currentBoy = first;
            } else {
                currentBoy.setNext(boy);
                boy.setNext(first);
                currentBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoy() {
        if (isEmpty()) {
            return;
        }
        Boy currentBoy = first;
        while(true) {
            System.out.printf("小孩的编号是：%d\n", currentBoy.getNo());
            if (currentBoy.getNext() == first) {
                break;
            }
            currentBoy = currentBoy.getNext();
        }
    }

    //获取链表大小
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        Boy currentBoy = first;
        int size = 0;
        while(true) {
            size++;
            if (currentBoy.getNext() == first) {
                break;
            }
            currentBoy = currentBoy.getNext();
        }
        return size;
    }
    /**
     * @Discription: 根据用户输入，计算小孩出圈顺序
     * @Param: StartNo 表示从第几个小孩开始数
     * @Param: countNum 表示数多少下
     * @Param: nums 表示最初由多少个小孩在圈中
     * @return: void
     * @Author: chen
     * @Date: 2022/7/4
     */
    public void Josephus(int startNo, int countNum) {
        //校验数据
        if (first == null || startNo < 1 || startNo > size()) {
            System.out.println("数据输入有误，布响丸啦！");
            return;
        }
        //创建一个辅助指针
        Boy helper = first;
        //将helper置于startNo的前一个位置
        if (startNo == 1){
            while (true) {
                if (helper.getNext() == first) {
                    break;
                }
                helper = helper.getNext();
            }
        } else {
            for (int i = 0; i < startNo - 2; i++) {
                helper = helper.getNext();
            }
            first = helper.getNext();
        }
        //将first置于helper后面，即startNo的位置
        //循环直到圈中只有一个节点
        while (true) {
            if (helper == first) { //说明圈中只有一个节点
                break;
            }
            //数k下
            for (int i  = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //将当前first删除
            System.out.println("小孩" + first.getNo() + "出圈 =>");
            helper.setNext(first.getNext());
            first = first.getNext();
        }
        System.out.println("最后留在圈中的小孩：" + first.getNo());
    }

    public boolean isEmpty() {
        if (first == null) {
            System.out.println("链表为空");
            return true;
        }
        return false;
    }
}
