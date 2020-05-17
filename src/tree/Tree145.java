package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/9/5
 */
public class Tree145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {

        if (root == null) return;
        helper(res, root.left);
        helper(res,root.right);
        res.add(root.val);
    }
}
