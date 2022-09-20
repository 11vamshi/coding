package com.vamshi.coding.bt;

public class L110_HeightBalanced {
    public boolean isBalanced(TreeNode root) {

        if(dfsHeight(root) != -1){
            return true;
        }
        else
            return false;
    }

    private int dfsHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1) { return -1;}
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1) { return -1;}

        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
