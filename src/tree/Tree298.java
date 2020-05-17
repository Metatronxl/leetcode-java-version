package tree;
import tree.TreeUtil.TreeNode;

/**
 * @author lei.X
 * @date 2019/9/24
 */
public class Tree298 {

    int maxLen = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null ) return 0;
        helper(root,1);
        return maxLen;
    }



    private void  helper(TreeNode root,int len){

        if (root.left == null && root.right == null){
            return;
        }

        if (root.left != null){
            if (root.left.val == root.val+1){
                len +=1;
                if (len > maxLen) maxLen = len;
                helper(root.left,len);
                len -=1;
            }else {
                int temp = len;
                len =1;
                helper(root.left,len);
                len = temp;
            }
        }


        if (root.right != null){
            if (root.right.val == root.val +1){
                len +=1;
                if (len > maxLen) maxLen = len;
                helper(root.right,len);
                len -=1;
            }else {
                int temp = len;
                len =1;
                helper(root.right,len);
                len = temp;
            }
        }

    }
}
