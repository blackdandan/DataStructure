package com.example.blackdandan.algorithm;

/**
 * description :各种排序算法
 * Created by blackdandan on 2017/8/15.
 */

public class Sorter {

    /**
     * 直接插入排序
     * @param ints
     */
    public static int[] StraightInsertionSort(int[] ints){
        /**
         * 照着书香写的,但是好像会少一个数字
         */
        for (int i = 2;i< ints.length ; ++i){
            if (ints[i] < ints[i-1]){
                ints[0] = ints[i];
                ints[i] = ints[i-1];
                int j;
                for (j = i-2 ;ints[0] < ints[j] ; --j){
                    ints[j+1] = ints[j];
                }
                ints[j + 1] = ints[0];

            }
        }
        return ints;
    }
    /**
     * 直接插入排序
     * @param ints
     */
    public static int[] StraightInsertionSort2(int[] ints){
        /**
         * 优化一下,
         */
        int guard ;//首先搞一个哨兵,用来存放当前用来做对比的数值
        for (int i = 1;i< ints.length ; i++){//从第二个数字才可产生对比,
            guard = ints[i];//哨兵放置当前用来做对比的值
            if (ints[i] < ints[i-1]){//做对比,如果顺序不对,就开始调整顺序,对的话就什么也不做
                ints[i] = ints[i-1];//将当前位置放之前一个位置的值
                int j = 0;
                if (i>=2){//这个是为了防止数组越界,因为如果超过了三个值,当前值要排到之前排好的顺序列表里面,要跟前面的一一对比m

                    //如果上面做了调整,肯定要跟之前的再对比,和调位置,直到找到合适的位置
                    //现在当前位置的值刚和之前一个值做了对比,之前的值放在了当前位置,当前位置的值放在了哨兵里面,
                    //所以要对比哨兵和前一个位置的前一个,直到,哨兵不再小于之前的值,那么,此时,哨兵的值应该放在不再小于哨兵的值后面,
                    //也就是j + 1;
                    for (j = i-2 ; j>=0 && guard < ints[j] ; j--){
                        ints[j +1 ] = ints[j];//当然,不能写反,我就写反了,导致很多值都一样了 o(╯□╰)o
                    }
                    ints[j + 1] = guard;//因为是从小到大排列,所以哨兵不再比对比的值小的时候,哨兵就应该放在这个值的后面
                }else {
                    ints[0] = guard;
                }



            }
        }
        return ints;
    }

    /**
     * 简单的冒泡排序,
     * 概念就是,相邻的两个比较,把大的,或者小的放在后面,使得最后一个是最大的
     * 下一趟使得倒数第一个是最大的
     * 以此类推
     * @param ints
     * @return
     */
    public static int[] bubbleSort(int[] ints){
        for (int i = 1; i < ints.length; i++){
            for (int j = 1; j <= ints.length -i; j++)
            if(ints[j] < ints[j-1] ){
                int temp = ints[j];
                ints[j] = ints[j-1];
                ints[j-1] = temp;
            }
        }
        return ints;
    }
}
