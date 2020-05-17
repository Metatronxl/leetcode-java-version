package tree;
import tree.TreeUtil.*;


/**
 * @author lei.X
 * @date 2019/9/25
 */
public class Tree104 {

    public int maxDepth(TreeNode root) {

        if (root == null) return 0;
        helper(root,1);
        return maxLen;
    }

    int maxLen = 1;

    private void helper(TreeNode root,int len){

        if(root.left == null && root.right == null){

            if (maxLen < len){
                maxLen = len;
            }
        }

        if (root.left != null){
            helper(root.left,len+1);
        }

        if (root.right != null){
            helper(root.right,len+1);
        }

    }
}
