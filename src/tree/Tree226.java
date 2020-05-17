package tree;


/**
 * @author lei.X
 * @date 2019/9/6
 */
public class Tree226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;
        if (root.left == null && root.right == null) return root;

        TreeNode l = root.left;
        TreeNode r = root.right;
        invertTree(l);
        invertTree(r);

        root.left = root.right;
        root.right = l;

        return root;

    }


}
