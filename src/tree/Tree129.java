package tree;

import java.util.ArrayList;
import java.util.List;
import tree.TreeUtil.*;

/**
 * @author lei.X
 * @date 2019/9/24
 * 方案1的解法
 */
public class Tree129 {



    public int sumNumbers(TreeNode root) {

        if (root == null) return 0;
        List<Integer> arrayList = new ArrayList<>();
        helper(root,root.val,arrayList);
        int totalSum = 0;
        for(int i=0;i<arrayList.size();i++){
            totalSum += arrayList.get(i);
        }
        return totalSum;
    }



    private void helper(TreeNode root, int subSum,List<Integer> arrayList) {

        if (root.left == null && root.right == null) {
            arrayList.add(subSum);
            return;
        }


        if (root.right != null) {

            int temp = subSum;
            subSum = subSum*10 + root.right.val;
            helper(root.right,subSum,arrayList);
            subSum = temp;
        }

        if (root.left  != null){
            int temp = subSum;
            subSum = subSum*10 + root.left.val;

            helper(root.left,subSum,arrayList);
            subSum = temp;
        }


    }


    public static void main(String[] args) {

        TreeNode root = TreeUtil.getTree();
        Tree129 test = new Tree129();
        test.sumNumbers(root);

    }

}
