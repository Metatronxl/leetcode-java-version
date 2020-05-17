package ProgrammerSkills;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author lei.X
 * @date 2020/5/9
 */
public class Question4_2 {


    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        if (len==0){
            return null;
        }
        if (len==1){
            return new TreeNode(nums[0]);
        }
        int midNode = nums[len/2];

        TreeNode curNode = new TreeNode(midNode);
        int[] leftPart = Arrays.copyOfRange(nums,0,len/2);
        int[] rightPart = Arrays.copyOfRange(nums,len/2+1,len);
        curNode.left = sortedArrayToBST(leftPart);
        curNode.right = sortedArrayToBST(rightPart);
        return curNode;
    }

    public static void main(String[] args) {
        Question4_2 question4_2 = new Question4_2();
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = question4_2.sortedArrayToBST(nums);
        System.out.println(treeNode);

    }
}
