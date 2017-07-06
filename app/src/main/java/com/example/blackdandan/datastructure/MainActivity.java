package com.example.blackdandan.datastructure;

import android.app.Activity;
import android.os.Bundle;

import com.example.blackdandan.datastructure.somedatastructure.queue.MyQueue;
import com.example.blackdandan.datastructure.somedatastructure.stack.MyStack;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        /**
//         * 测试 {@link com.example.blackdandan.datastructure.somedatastructure.list.MyList}
//         */
//        MyList<String> list = new MyList<>();
//        for (int i = 0 ;i<10;i++){
//            list.add(""+i);
//        }
//        System.out.println("do====List.size:"+list.size());
//
//        System.out.println("do====List.isEmpty"+list.isEmpty());
//        for (int i = 0 ;i<list.size();i++){
//            System.out.println("do====List.get"+i+":"+list.get(i));
//        }
//        /**
//         * 测试 {@link MyStack}
//         */
//        MyStack<Integer> myStack = new MyStack<>();
//        for (int i = 0;i<10;i++){
//            myStack.push(i);
//        }
//        for (int i = 0;i<10;i++){
//            System.out.println("do===="+i+"=="+myStack.pop());
//        }
        /**
         * 测试 {@link com.example.blackdandan.datastructure.somedatastructure.queue.MyQueue}
         *
         */
        MyQueue<String> queue= new MyQueue<>();
        for (int i = 0;i<11;i++){
            queue.enQueue("学生:"+(i+1));
        }
        System.out.println("do====queue.size "+queue.size());
        int size = queue.size();
        for (int i = 0;i<size;i++){
            System.out.println("do===="+queue.deQueue()+"排队结束");
        }
        for (int i = 0;i<11;i++){
            queue.enQueue("学生:"+(i+1));
        }
        System.out.println("do====queue.size "+queue.size());
        int size2 = queue.size();
        for (int i = 0;i<size2;i++){
            System.out.println("do===="+queue.deQueue()+"排队结束");
        }

    }
}
