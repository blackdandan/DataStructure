package com.example.blackdandan.datastructure;

import android.app.Activity;
import android.os.Bundle;

import com.example.blackdandan.datastructure.somedatastructure.bitree.MyBiTree;
import com.example.blackdandan.datastructure.somedatastructure.queue.MyQueue;
import com.example.blackdandan.datastructure.somedatastructure.stack.MyStack;

import java.util.TreeMap;

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
//        /**
//         * 测试 {@link com.example.blackdandan.datastructure.somedatastructure.queue.MyQueue}
//         *
//         */
//        MyQueue<String> queue= new MyQueue<>();
//        for (int i = 0;i<11;i++){
//            queue.enQueue("学生:"+(i+1));
//        }
//        System.out.println("do====queue.size "+queue.size());
//        int size = queue.size();
//        for (int i = 0;i<size;i++){
//            System.out.println("do===="+queue.deQueue()+"排队结束");
//        }
//        for (int i = 0;i<11;i++){
//            queue.enQueue("学生:"+(i+1));
//        }
//        System.out.println("do====queue.size "+queue.size());
//        int size2 = queue.size();
//        for (int i = 0;i<size2;i++){
//            System.out.println("do===="+queue.deQueue()+"排队结束");
//
//        }
        MyBiTree<String> myBiTree =new MyBiTree<>("-");
        MyBiTree<String> leftFormula =new MyBiTree<>("+");
        MyBiTree<String> rightFormula = new MyBiTree<>("/");
        leftFormula.insertLeftTree(new MyBiTree<>("a"));

        MyBiTree<String> multiplyFormula = new MyBiTree<>("*");
        multiplyFormula.insertLeftTree(new MyBiTree<String>("b"));

        MyBiTree<String> decrementFormula = new MyBiTree<>("-");
        decrementFormula.insertLeftTree(new MyBiTree<String>("c"));
        decrementFormula.insertRightTree(new MyBiTree<String>("d"));

        multiplyFormula.insertRightTree(decrementFormula);

        leftFormula.insertRightTree(multiplyFormula);
        rightFormula.insertLeftTree(new MyBiTree<>("e"));
        rightFormula.insertRightTree(new MyBiTree<>("f"));
        myBiTree.insertLeftTree(leftFormula);
        myBiTree.insertRightTree(rightFormula);
        final StringBuilder stringBuilder = new StringBuilder();
        MyBiTree.VisitCallBack callBack = new MyBiTree.VisitCallBack() {
            @Override
            public void visit(MyBiTree myBiTree) {
                stringBuilder.append(myBiTree.getData());
            }
        };
        System.out.println("==============preOrder======");
        myBiTree.preOrderTraverse(callBack);
        System.out.println("=============="+stringBuilder.toString());
        stringBuilder.delete(0,stringBuilder.length());
        System.out.println("==============preOrder======");
        System.out.println("==============postOrderTraverse======");
        myBiTree.postOrderTraverse(callBack);
        System.out.println("=============="+stringBuilder.toString());
        stringBuilder.delete(0,stringBuilder.length());
        System.out.println("==============postOrderTraverse======");
        System.out.println("==============afterOrderTraverse======");
        myBiTree.afterOrderTraverse(callBack);
        System.out.println("=============="+stringBuilder.toString());
        stringBuilder.delete(0,stringBuilder.length());
        System.out.println("==============afterOrderTraverse======");

    }
}
