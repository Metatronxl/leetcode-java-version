package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2019/9/5
 */
public class TreeUtil {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 由数组构建一颗二叉树
     */

    public TreeNode buildBinaryTreeWithArray(int[] treeArray) {


        TreeNode root = createBinaryTreeByArray(treeArray, 0);
        return root;
    }

    /**
     * 由数组构建不完整二叉树
     * @param treeList
     * @return
     */
    public TreeNode buildBinaryTreeWithArray(List<Integer> treeList){

        TreeNode root = createBinaryTreeByList(treeList,0);
        return root;

    }

    private TreeNode createBinaryTreeByList(List<Integer> treeList, int index) {
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


    private TreeNode createBinaryTreeByArray(int[] array, int index) {
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


    public static TreeNode getTree(){

        List<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(1);
        array.add(null);
        array.add(null);
        array.add(2);



        TreeUtil test = new TreeUtil();

        return test.buildBinaryTreeWithArray(array);
    }





    public static void main(String[] args) {


        List<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(9);
        array.add(20);
        array.add(null);
        array.add(null);
        array.add(15);
        array.add(7);

        TreeUtil test = new TreeUtil();

        TreeNode root =  test.buildBinaryTreeWithArray(array);
        System.out.println(root);
    }

}

