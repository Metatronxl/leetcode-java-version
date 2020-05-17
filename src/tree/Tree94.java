package tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/9/5
 */
public class Tree94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        helper(res,root);
        return  res;
    }

    private void helper(List<Integer> res, TreeNode root) {

        if (root == null) return;
        helper(res,root.left);
        res.add(root.val);
        helper(res,root.right);


    }


}
