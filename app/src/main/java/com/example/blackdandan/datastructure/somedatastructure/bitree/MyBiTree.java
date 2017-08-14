package com.example.blackdandan.datastructure.somedatastructure.bitree;

/**
 * description :
 * 二叉树例子
 * Created by blackdandan on 2017/7/14.
 */

public class MyBiTree<Data> {
    private MyBiTree<Data> mLeftTree;
    private MyBiTree<Data> mRightTree;
    private MyBiTree<Data> mParentTree;
    private Data data;
    public MyBiTree(Data data){
        this.data = data;
    }

    public void destroyBiTree(){
        //遍历树置空引用
        this.preOrderTraverse(new VisitCallBack() {
            @Override
            public void visit(MyBiTree myBiTree) {
                if (myBiTree!=null){
                    if (myBiTree.mLeftTree != null){
                        mLeftTree.destroyBiTree();
                    }
                    if (myBiTree.mRightTree !=null){
                        mRightTree.destroyBiTree();
                    }
                    myBiTree.data = null;
                    myBiTree = null;
                }
            }
        });
    }
    public void clearBitree(){
        //遍历树置空数据
        this.preOrderTraverse(new VisitCallBack() {
            @Override
            public void visit(MyBiTree myBiTree) {
                if (myBiTree!=null){
                    myBiTree.data = null;
                }
            }
        });
    }
    public boolean isEmpty(){
        return data == null;
    }
    public int depth(){
        if (mLeftTree!=null&&mRightTree!=null){
            return mLeftTree.depth()>mRightTree.depth()?mLeftTree.depth()+1:mRightTree.depth()+1;
        }
        else if (mLeftTree != null){
            return mLeftTree.depth()+1;
        }
        else if (mRightTree!=null){
            return mRightTree.depth()+1;
        }else {
            return 1;
        }
    }
    public MyBiTree root(){
        if (mParentTree!=null){
            return mParentTree.root();
        }else {
            return mParentTree;
        }
    }
    public Data getData(){
        return data;
    }
    public void Assign(Data data,MyBiTree<Data> tree){
        tree.data = data;
    }
    public MyBiTree<Data> getParent(MyBiTree<Data> tree){
        return mParentTree;
    }
    public MyBiTree<Data> getmLeftTree(){
        return mLeftTree;
    }
    public MyBiTree<Data> getmRightTree(){
        return mRightTree;
    }
    public MyBiTree<Data> getLeftBrother(MyBiTree<Data> mTree){
        return getParent(mTree).getmLeftTree();
    }
    public MyBiTree<Data> getRightBrother(MyBiTree<Data> mTree){
        return getParent(mTree).getmRightTree();
    }
    public void insert(MyBiTree<Data> mTree){

    }
    public void insertLeftTree(MyBiTree<Data> mLeftTree){
        this.mLeftTree = mLeftTree;
    }
    public void insertRightTree(MyBiTree<Data> mRightTree){
        this.mRightTree = mRightTree;
    }
    public void preOrderTraverse(VisitCallBack callBack){
        callBack.visit(this);
        if (mLeftTree!=null)mLeftTree.preOrderTraverse(callBack);
        if (mRightTree!=null)mRightTree.preOrderTraverse(callBack);
    }
    public void postOrderTraverse(VisitCallBack callBack){
        if (mLeftTree!=null)mLeftTree.postOrderTraverse(callBack);
        callBack.visit(this);
        if (mRightTree!=null)mRightTree.postOrderTraverse(callBack);
    }
    public void afterOrderTraverse(VisitCallBack callBack){
        if (mLeftTree!=null)mLeftTree.afterOrderTraverse(callBack);
        if (mRightTree!=null)mRightTree.afterOrderTraverse(callBack);
        callBack.visit(this);
    }
    public interface VisitCallBack{
        void visit(MyBiTree myBiTree);
    }

}