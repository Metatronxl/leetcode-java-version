package tree;

/**
 * @author lei.X
 * @date 2019/9/6
 */
public class Tree101 {

    private boolean flag = true;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {

        if (root == null) return true;

        helper(root.left,root.right);
        return flag;

    }

    private void helper(TreeNode left, TreeNode right){

        if (left == null && right == null){
            return;
        }

        if (left == null || right == null){
            flag = false;
            return;
        }

        if (left.val != right.val){
            flag = false;
            return;
        }

        helper(left.left,right.right);
        helper(left.right,right.left);
    }
}
