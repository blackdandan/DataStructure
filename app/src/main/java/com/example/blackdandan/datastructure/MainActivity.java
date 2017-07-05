package com.example.blackdandan.datastructure;

import android.app.Activity;
import android.os.Bundle;

import com.example.blackdandan.datastructure.somedatastructure.list.MyList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 测试 {@link com.example.blackdandan.datastructure.somedatastructure.list.MyList}
         */
        MyList<String> list = new MyList<>();
        for (int i = 0 ;i<10;i++){
            list.add(""+i);
        }
        System.out.println("do====List.size:"+list.size());

        System.out.println("do====List.isEmpty"+list.isEmpty());
        for (int i = 0 ;i<list.size();i++){
            System.out.println("do====List.get"+i+":"+list.get(i));
        }
    }
}
