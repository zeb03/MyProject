package com.ze.simple;

/**
 * @author ze
 * @date 2022-10-14 23:31
 */
public class SortedArrayToBST {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return function(nums, 0, nums.length - 1);
    }

    public TreeNode function(int[] nums, int left, int right) {
        if (nums.length == 0) {
            return null;
        }
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = function(nums, left, mid - 1);
        node.right = function(nums, mid + 1, right);
        return node;
    }
}
