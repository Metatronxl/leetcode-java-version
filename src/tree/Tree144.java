package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/9/3
 */
public class Tree144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }


    private void helper(List<Integer> res, TreeNode root) {

        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}
