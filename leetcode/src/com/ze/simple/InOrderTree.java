package com.ze.simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ze
 * @Time 2022-10-02 22:40
 */
public class InOrderTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrder(root,list);
        return list;
    }

    public void InOrder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        InOrder(root.left,list);
        list.add(root.val);
        InOrder(root.right,list);
    }

    //非递归实现
    /*
    知识点：Deque实现栈与队列
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
