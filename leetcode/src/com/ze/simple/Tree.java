package com.ze.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ze
 * @Time 2022-10-02 23:01
 */
public class Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //是否为相同二叉树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //是否为轴对称
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return symmetric(root.left, root.right);
    }

    public boolean symmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val == q.val) {
            return symmetric(p.left, q.right) && symmetric(p.right, q.left);
        }
        return false;
    }

    //队列非递归实现
    //offer入队,poll出队
    public boolean symmetric1(TreeNode u, TreeNode v){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()){
            u = queue.poll();
            v = queue.poll();
            if(u == null && v == null){
                return true;
            } else if((u == null || v == null) || u.val != v.val){
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }

    //返回最大深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        return lDepth > rDepth ? lDepth + 1 : rDepth + 1;
    }
}