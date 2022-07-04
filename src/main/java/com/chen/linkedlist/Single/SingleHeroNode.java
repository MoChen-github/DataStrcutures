package com.chen.linkedlist.Single;

// 定义一个HeroNode， 每个HeroNode对象就是一个节点
public class SingleHeroNode {
    public int no;
    public String name;
    public String nickName;
    public SingleHeroNode next;

    public SingleHeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
