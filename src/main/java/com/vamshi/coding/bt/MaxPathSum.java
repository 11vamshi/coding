package com.vamshi.coding.bt;

public class MaxPathSum {

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        rec(root, max);
        return max[0];
    }

    private int rec(TreeNode root, int[] max) {
        if(root == null){
            return 0;
        }

//        int leftNodeMaxSum = rec(root.left, max);
//        int rightNodeMaxSum = rec(root.right, max);
        int leftNodeMaxSum = Math.max(0, rec(root.left, max));
        int rightNodeMaxSum = Math.max(0, rec(root.right, max));

        max[0] = Math.max(max[0], root.val+leftNodeMaxSum + rightNodeMaxSum);

        return root.val + Math.max(leftNodeMaxSum,rightNodeMaxSum);
    }

}
