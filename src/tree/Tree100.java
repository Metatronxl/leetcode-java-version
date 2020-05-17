package tree;
import tree.TreeUtil.*;

/**
 * @author lei.X
 * @date 2019/9/6
 */
public class Tree100 {


    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {

        helper(p,q);
        return flag;
    }

    private void helper(TreeNode p , TreeNode g){

        if (p == null && g == null){
            return;
        }

        if (p == null || g == null){
            flag = false;
            return;
        }

        if (p.val != g.val){
            flag = false;
            return;
        }else{
            isSameTree(p.left,g.left);
            isSameTree(p.right,g.right);
        }

        return;
    }

}
