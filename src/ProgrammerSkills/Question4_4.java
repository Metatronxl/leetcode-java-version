package ProgrammerSkills;

import util.ConstuctTreeWithArray;
import util.TreeNode;

import java.util.Arrays;

/**
 * @author lei.X
 * @date 2020/5/11
 */
public class Question4_4 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) return true;
        getDepth(root);
        return !breakBalance;
    }


    public boolean breakBalance = false;

    public int getDepth(TreeNode root){

        if (breakBalance){
            return 0;
        }
        if (root == null){
            return 0;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        if (Math.abs(leftDepth-rightDepth) > 1){
            breakBalance = true;
            return 0;
        }

        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {

        Integer[] nums = {1,null,2,null,3};

        TreeNode  treeNode = ConstuctTreeWithArray.buildBinaryTreeWithArray(Arrays.asList(nums));

        Question4_4 question4_4 = new Question4_4();
        question4_4.isBalanced(treeNode);
    }
}
