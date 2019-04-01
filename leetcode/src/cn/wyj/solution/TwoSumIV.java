package cn.wyj.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoSumIV {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean findTarget(TreeNode root, int k) {
        if (root == null || root.left == null && root.right == null)
            return false;
        HashSet<Integer> s = new HashSet<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode tmp = que.pop();
            if (s.contains(k-tmp.val))
                return true;
            s.add(tmp.val);
            if (tmp.left != null)
                que.add(tmp.left);
            if (tmp.right != null)
                que.add(tmp.right);
        }

        return false;
    }
}
