package com.chen.linkedList.stack;

import com.chen.stack.ArrayStack;
import org.junit.Test;

import java.util.Scanner;

public class ArrayStackTest {
    @Test
    public void testArrayStack() {
        createMenu(4);
    }

    public void createMenu(int maxsize) {
        ArrayStack stack = new ArrayStack(maxsize);
        String key;
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 显示栈");
            System.out.println("push: 添加数据到栈（入栈）");
            System.out.println("pop: 从栈中取出数据（出栈）");
            System.out.println("exit: 退出程序");
            System.out.println("请输入你的选择");

            key = scanner.next();
            switch (key) {
                case "show":
                    stack.showStack();
                    break;
                case "push":
                    System.out.println("请输入一个");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.println("出战的数据是："+ res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

