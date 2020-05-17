package tree;

import java.lang.reflect.Array;
import java.util.Arrays;
/**
 * @author lei.X
 * @date 2020/4/23
 */

public class Test {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    private static int FindLocation(int[] in, int value){

        for (int i=0;i<in.length;i++){
            if (in[i] == value){
                return i;
            }
        }

        return -1;

    }

    private static TreeNode buildTree(int[] in, int[] pre){

        if (in.length==0){
            return null;
        }

        int rootVal = pre[0];
        int inIdx = FindLocation(in,rootVal);
        TreeNode root = new TreeNode(rootVal);

        int[] leftIn = Arrays.copyOfRange(in,0,inIdx);
        int[] leftPre = Arrays.copyOfRange(pre,1,1+leftIn.length);
        root.left = buildTree(leftIn,leftPre);

        int[] rightIn = Arrays.copyOfRange(in,inIdx+1,in.length);
        int[] rightPre = Arrays.copyOfRange(pre,1+leftPre.length,pre.length);
        root.right = buildTree(rightIn,rightPre);


        return root;

    }




    public static void main(String[] args) {

        int[] in = new int[]{9,3,15,20,7};
        int[] pre = new int[]{3,9,20,15,7};

        TreeNode treeNode = buildTree(in, pre);
        System.out.println(treeNode);
    }
}
