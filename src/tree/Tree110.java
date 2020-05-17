package tree;
import tree.TreeUtil.*;

/**
 * @author lei.X
 * @date 2019/9/26
 */
public class Tree110 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        int res = helper(root);
        return flag;
    }
    boolean flag = true;

    private int helper(TreeNode root){

        if (root == null) return 0;
        // leaf node
        if (root.left == null &&  root.right == null){
            return 1;
        }

        int leftLen = helper(root.left);
        int rightLen = helper(root.right);

        if (Math.abs(leftLen - rightLen) > 1){
            flag = false;
        }
        return (leftLen>rightLen ? leftLen : rightLen) +1 ;

    }

    public static void main(String[] args) {

        TreeNode root = TreeUtil.getTree();
        Tree110 test =  new Tree110();
        test.isBalanced(root);
    }
}
