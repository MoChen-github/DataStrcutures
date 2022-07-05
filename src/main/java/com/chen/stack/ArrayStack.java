package com.chen.stack;

public class ArrayStack {
    private final int maxSize; //栈的大小（固定大小）
    private final int [] stack; //数组模拟栈的结构，数据就放在该数组中；
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //入栈 - push
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，无法加入");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况（遍历栈）， 需从栈顶开始显示
    public void showStack(){
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        //需从栈顶开始显示数据
        for (int i = top; i >= 0 ; i--) {
            System.out.println("stack[" + i + "] = " + stack[i]);
        }
    }
    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return  top == -1;
    }
}
