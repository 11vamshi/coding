package com.vamshi.coding.bst;

import com.vamshi.coding.bt.TreeNode;
import lombok.val;

import java.util.Stack;

class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode temp = stack.pop();
        TreeNode t = temp.right;
        while(t != null){
            stack.push(t);
            t = t.left;
        }
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        BSTIterator iterator = new BSTIterator(root);

    }


}
