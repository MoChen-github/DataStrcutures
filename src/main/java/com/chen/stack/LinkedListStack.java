package com.chen.stack;


public class LinkedListStack {
    private LinkedStackNode top;
    private final LinkedStackNode head = new LinkedStackNode(-1);

    public LinkedListStack() {

    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法取出");
        }

        int value = top.getNumber();
        head.setNext(top.getNext());
        top = top.getNext();
        return value;
    }

    public void push(int value) {
        LinkedStackNode newNode = new LinkedStackNode(value);
        head.setNext(newNode);
        newNode.setNext(top);
        top = newNode;
    }
    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int size = 0;
        LinkedStackNode temp = top;
        while (true) {
            if (temp.getNext() == null) {
                size++;
                break;
            }
            size++;
            temp = temp.getNext();
        }
        return size;
    }

    public int getTop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return top.getNumber();
    }

    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return;
        }
        LinkedStackNode currentNode = top;
        for (int i = 0; i < size(); i++) {
            System.out.printf("从栈顶开始第%d个元素为%d\n", i + 1, currentNode.getNumber());
            currentNode = currentNode.getNext();
        }
    }


   static class LinkedStackNode {
       private int Number;
       private LinkedStackNode next;

       public LinkedStackNode(int number) {
           Number = number;
       }

       public int getNumber() {
           return Number;
       }

       public void setNumber(int number) {
           Number = number;
       }

       public LinkedStackNode getNext() {
           return next;
       }

       public void setNext(LinkedStackNode next) {
           this.next = next;
       }

       @Override
       public String toString() {
           return "LinkedStackNode{" +
                   "Number=" + Number +
                   '}';
       }
   }
}
