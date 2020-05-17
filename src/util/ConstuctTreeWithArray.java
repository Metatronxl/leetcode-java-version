package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lei.X
 * @date 2020/5/11
 */
public class ConstuctTreeWithArray {




    /**
     * 由数组构建一颗二叉树
     */

    public static TreeNode buildBinaryTreeWithArray(int[] treeArray) {


        TreeNode root = createBinaryTreeByArray(treeArray, 0);
        return root;
    }

    /**
     * 由数组构建不完整二叉树
     * @param treeList
     * @return
     */
    public static TreeNode buildBinaryTreeWithArray(List<Integer> treeList){

        TreeNode root = createBinaryTreeByList(treeList,0);
        return root;

    }

    private static TreeNode createBinaryTreeByList(List<Integer> treeList, int index) {
        TreeNode root = null;
        if (index < treeList.size()){
            if (treeList.get(index) == null){
                root = null;
            }else{
                root = new TreeNode(treeList.get(index));
                root.left = createBinaryTreeByList(treeList,2*index+1);
                root.right = createBinaryTreeByList(treeList,2*index+2);
                return root;
            }

        }
        return root;


    }

    private static TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }


    public static void main(String[] args) {

        Integer[] testArray = {1,2,3,4,5,null,7,8};
        TreeNode treeNode = buildBinaryTreeWithArray(Arrays.asList(testArray));
        System.out.println(treeNode);


    }


}
