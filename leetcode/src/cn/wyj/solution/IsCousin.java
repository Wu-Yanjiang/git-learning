package cn.wyj.solution;

import java.util.*;

public abstract class IsCousin {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //考虑层次遍历法，一层同时出现两者则返回true，否则返回false
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode cur = root;
        boolean xFlag = false, yFlag = false;

        LinkedList<TreeNode> l = new LinkedList<>();
        l.addFirst(cur);
        TreeNode tmp;
        int dp = 0;
        while (!l.isEmpty()) {
            tmp = l.removeFirst();
            //tmp指向了x或y则标记置true
            if (tmp.val == x)
                xFlag = true;
            if (tmp.val == y)
                yFlag = true;

            //将左右子树加入队列
            if (tmp.left != null)
                l.addLast(tmp.left);
            if (tmp.right != null)
                l.addLast(tmp.right);


            //同一个父节点直接返回false
            if (tmp.left != null && tmp.right != null){
                if (tmp.left.val == x && tmp.right.val == y)
                    return false;
                else if (tmp.left.val == y && tmp.right.val == x)
                    return false;
            }
        }

        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.poll();

        if (xFlag && yFlag) {
            return true;
        }
        else {
            return false;
        }



    }

}
