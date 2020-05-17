package tree;

import tree.TreeUtil.TreeNode;

/**
 * @author lei.X
 * @date 2019/9/16
 */
public class Tree112 {

    boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {

        helper(0, sum, root);

        return flag;
    }


    private void helper(int temp, int sum, TreeNode root) {

        if (root == null) return;

        if (root.left == null && root.right == null) {
            temp += root.val;
            if (temp == sum) {
                flag = true;
                return;
            }
            temp -= root.val;
        }

        if (root.left != null) {
            temp += root.val;
            helper(temp, sum, root.left);
            temp -= root.val;
        }

        if (root.right != null) {
            temp += root.val;
            helper(temp, sum, root.right);
            temp -= root.val;
        }

    }
}

