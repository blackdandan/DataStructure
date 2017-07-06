package com.example.blackdandan.datastructure.somedatastructure.stack;

import java.util.Stack;

/**
 * description :
 * Created by blackdandan on 2017/7/5.
 */

public class MyStack<T> {
    private Node<T> topNode;
    private int size = 0;
    private Node<T> base;
    public MyStack(){
        this.size = 0;
        this.base = new Node<>(null,null);
        this.topNode = new Node<>(null,base);

    }
    public void push(T data){
        Node<T> item = new Node<>(data,topNode);
        topNode = item;
        size ++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T pop(){
        if (isEmpty())return null;
        T topData = topNode.data;
        topNode = topNode.base;
        size --;
        return topData;
    }
    private class Node<T>{
        public T data;
        public Node<T> base;
        public Node(T data,Node<T> base){
            this.data = data;
            this.base = base;
        }
    }
}
