package tree;
import tree.TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/9/16
 */
public class Tree113 {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return Collections.emptyList();

        helper(res, new ArrayList<>(),0, sum, root);

        return res;
    }

    private void helper(List<List<Integer>> res , List<Integer> tempList,int temp, int sum, TreeNode root) {


        if (root.left == null && root.right == null) {
            tempList.add(root.val);
            temp += root.val;
            if (temp == sum) {
                res.add(new ArrayList<>(tempList));
                temp -= root.val;
                tempList.remove(tempList.size()-1);
                return;
            }
            temp -= root.val;
            tempList.remove(tempList.size()-1);

        }

        if (root.left != null) {
            tempList.add(root.val);
            temp += root.val;
            helper(res,tempList,temp, sum, root.left);
            temp -= root.val;
            tempList.remove(tempList.size()-1);
        }

        if (root.right != null) {
            tempList.add(root.val);
            temp += root.val;
            helper(res,tempList,temp, sum, root.right);
            temp -= root.val;
            tempList.remove(tempList.size()-1);
        }

    }


    public static void main(String[] args) {

        Tree113 test = new Tree113();
        TreeNode root = TreeUtil.getTree();
        System.out.println(test.pathSum(root,22));

    }
}
