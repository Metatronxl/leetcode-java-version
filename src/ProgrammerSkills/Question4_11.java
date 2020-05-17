package ProgrammerSkills;

import util.ConstuctTreeWithArray;
import util.TreeNode;

import java.util.Arrays;

public class Question4_11 {

    public int count=0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        helper(root,sum,0);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return count;
    }

    //累加 function
    public void helper(TreeNode root,int sum ,int temp){

        if (root==null) return;  // tree到底返回
        temp += root.val;
        if (temp == sum){
            count++;
        }
        helper(root.left,sum,temp);
        helper(root.right,sum,temp);

    }

    public static void main(String[] args) {

        Integer[] nums = {1,-2,-3,1,3,-2,null,-1};
        TreeNode treeNode = ConstuctTreeWithArray.buildBinaryTreeWithArray(Arrays.asList(nums));

        Question4_11 question4_11 = new Question4_11();
        question4_11.pathSum(treeNode,-1);

    }
}
