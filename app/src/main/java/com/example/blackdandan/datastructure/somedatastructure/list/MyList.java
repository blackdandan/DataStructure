package com.example.blackdandan.datastructure.somedatastructure.list;


/**
 * @description :参照List实现一个链表
 * 按链表的组织形式分忧ArrayList和LinkList两种,ArrayList内部其实是用数组的形式实现链表,比较适合链表大小
 * 确定或较少对链表进行增删操作的情况,对链表节点的访问时间O(n)与链表长度有关
 * 另外根据实现形式,可以分为直接式,和使用Iterable(迭代器)接口或者也可以在链表的内部自己定义Iterable接口
 * Created by blackdandan on 2017/7/5.
 */

public class MyList<A> {
    private int mSize = 0;//链表的长度
    private Node<A> pre;//上一个节点数据
    private Node<A> next;//下一个节点数据
    private A data;//本节点数据
    private Node<A> header;
    private Node<A> tail;

    public MyList(){
        this.mSize = 0;
        this.header = new Node<>(null,null,null);
        this.tail = new Node<>(null,header,null);
        header.next = tail;
    }

    /**
     * 返回List的大小
     * @return
     */
    public int size(){
        return mSize;
    }
    /**
     * 在末尾添加一个新的节点
     * @param item
     */
    public void add(A item){
        Node<A> aNode = new Node<>(item,null,null);
        tail.pre.next = aNode;
        aNode.pre = tail.pre;
        aNode.next = tail;
        tail.pre = aNode;
        mSize ++;
    }


    /**
     * 获取置顶索引处的节点的数据
     * @param index
     * @return
     */
    public A get(int index){
        if (index >this.mSize-1 ||index<0)
            throw new IndexOutOfBoundsException();
        Node<A> current  = header;
        for (int i = 0;i<=index; i++){
            current = current.next;
        }
        return current.data;
    }

    public boolean isEmpty(){
        return mSize == 0;
    }
    /**
     * 节点
     * @param <A>
     */
    private class Node<A>{
        public A data;
        public Node<A> pre;
        public Node<A> next;
        public Node(A data,Node<A> pre,Node<A> next){
            this.data = data;
            this.pre = pre;
            this.next = next;
        }


    }

}
