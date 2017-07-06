package com.example.blackdandan.datastructure.somedatastructure.queue;

/**
 * description :
 * 队列的实现:
 * 1,注意,deQueue的时候, 最后一个元素出了队列之后,队伍尾巴 = 队伍头部,以此来判断还能不能deQueue,不能dequeue
 * 的时候就跑出一个异常
 * 2.插入队列只要知道最后一个元素是谁就行了,出队列只要知道第一个元素是谁就行了
 * 3.初始化:定义一个空的头,尾巴等于头
 * 4.进入队列:之前的最后一个的下一个 = 正在进入的这个节点
 * 5.离开队列:队首离开,队首的下一个成为队首;
 *
 *一开始还以为Dequeue的时候需要注意吧tail不小心弄成空的情况
 * 不过在java里面,head.next = tail的时候,正好还有一个元素
 * 取出这个元素的时候
 * 首先把head.data 取出
 * 然后把head.next = head
 * 也就是tail = head
 * 此时head.next = null
 * 其实不用像在C语言中一样去注意这个好像
 * Created by blackdandan on 2017/7/6.
 */

public class MyQueue<T> {
    private Node<T> head;
    private int size;
    private Node<T> tail;
    public MyQueue(){
        tail = new Node<T>(null,null);
        head = new Node(null,null);
        tail = head;
        size = 0;
    }

    /**
     * 排队的时候只要知道最后一个是谁就行了,排上之后自己就成了最后一个
     * 之前的最后一个的下一个就成了自己
     * @param data
     */
    public void enQueue(T data){
        Node<T> element = new Node<>(null,data);
        tail.next = element;
        tail = element;
        size++;
    }
    public T deQueue(){
        if (head == null){
            throw new IndexOutOfBoundsException();
        }
        T data;
        data = head.next.data;
        head = head.next;
        size --;
//        if (size == 0){
//            tail = head;
//        }
        return data;
    }
    private class Node<T>{
        public Node<T> next;
        public T data;
        public Node(Node<T> next,T data){
            this.next = next;
            this.data = data;
        }
    }
    public int size(){
        return size;
    }
}
