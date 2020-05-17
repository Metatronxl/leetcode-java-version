package ProgrammerSkills;

import util.TreeNode;

/**
 * @author lei.X
 * @date 2020/5/17
 */
public class Question4_8 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q ) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if (left != null && right != null){
            return root;
        }else  if (left!= null){
            return left;
        }else {
            return right;
        }

    }


}
